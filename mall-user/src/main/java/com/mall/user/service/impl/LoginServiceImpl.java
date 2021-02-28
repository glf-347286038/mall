package com.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.user.client.OauthServiceClient;
import com.mall.user.common.config.MyJwt;
import com.mall.user.common.sys.SelfIncreasingUtil;
import com.mall.user.common.util.RedisUtils;
import com.mall.user.mapper.MallUserMapper;
import com.mall.user.mapper.UserAccountMapper;
import com.mall.user.model.dto.MallUserDTO;
import com.mall.user.model.entity.MallUser;
import com.mall.user.model.entity.UserAccount;
import com.mall.user.service.LoginService;
import com.mall.user.service.MallUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * @author: gaolingfeng
 * @date: 2021/1/11 20:59
 * @description:
 */
@Service
@Slf4j
@PropertySource("classpath:application-al.yml")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private OauthServiceClient oauthServiceClient;

    @Autowired
    private MallUserMapper mallUserMapper;

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private SelfIncreasingUtil selfIncreasingUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MallUserService mallUserService;


    public static final String REDIS_PREFIX = "mall-user:mall-user:userId";


    @Value("${oauth2.client-id}")
    private String clientId;

    @Value("${oauth2.client-secret}")
    private String clientSecret;

    @Value("${oauth2.grant-type}")
    private String grantType;

    public static final String GRANT_TYPE = "refresh_token";
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public MyJwt getJwt(String userName, String password) {
        // 远程请求授权服务器获取token
        MyJwt myJwt = oauthServiceClient.getToken(userName, password, grantType, clientId, clientSecret);
        // 为空直接返回空对象
        if (ObjectUtils.isEmpty(myJwt)) {
            return myJwt;
        }
        // 先查redis中有没有userId
        // redis的key命名方式未 项目名:表名:字段名:字段值
        Object redisUser = redisUtils.hashGet(REDIS_PREFIX, String.valueOf(myJwt.getInfo().getUserId()));
        // redis中如果有，mysql中一定有值，不是首次登录，直接返回jwt
        if (!ObjectUtils.isEmpty(redisUser)) {
            return myJwt;
        } else {
            // redis中若没有,去查mysql有没有，mysql中若也没有，则为首次登录系统，mall_user表中没存数据
            // 先往mysql中mall_user表插入数据,再跟新到redis中
            QueryWrapper<MallUser> wrapper = new QueryWrapper<>();
            MallUser mallUser = mallUserMapper.selectById(myJwt.getInfo().getUserId());
            if (ObjectUtils.isEmpty(mallUser)) {
                // 存入mysql 创建账户，往账户表中继续存入信息
                mallUser = this.insertMallUserAndAccount(myJwt);
            }
            // 存入redis,而jackson的反序列化需要无参构造函数
            this.insertMallUserToRedis(mallUser);
        }
        return myJwt;
    }

    @Override
    public void checkToken(String token) {
        oauthServiceClient.checkAccessToken(token);
    }

    @Override
    public MyJwt refreshToken(String refreshToken) {
        // 远程刷新token
        return oauthServiceClient.refreshToken(refreshToken, GRANT_TYPE, clientId, clientSecret);
    }

    @Override
    public String logout() {
        return "退出登录";
    }

    /**
     * 插入mall-user、user-account表
     * @author: gaolingfeng
     * @date: 2021/2/24 22:15
     * @param myJwt 用户信息
     * @return void
     */
    @Transactional(rollbackFor = Exception.class)
    public MallUser insertMallUserAndAccount(MyJwt myJwt) {
        MallUser mallUser = new MallUser();
        Integer accountId = selfIncreasingUtil.getNextKey("user_account","ACCOUNT_ID");
        mallUser.setUserId(myJwt.getInfo().getUserId());
        mallUser.setUserName(myJwt.getInfo().getUserName());
        mallUser.setPhone(myJwt.getInfo().getPhone());
        mallUser.setSex(myJwt.getInfo().getSex());
        mallUser.setAge(Integer.valueOf(myJwt.getInfo().getAge()));
        mallUser.setAccountId(accountId);
        mallUserMapper.insert(mallUser);
        UserAccount userAccount = new UserAccount();
        userAccount.setAccountId(accountId);
        // 密码加密存储默认为password:+666666 这样子就算别人解密了，也不知道是666666
        userAccount.setAccountPassword(passwordEncoder.encode("password:" + "666666"));
        // k1是明文密码，k2为加密过的密码，返回true或false
        // 返回 boolean passwordEncoder.matches(k1,k2);
        userAccountMapper.insert(userAccount);
        return mallUser;
    }

    /**
     * 将用户信息存储到redis中
     */
    public void insertMallUserToRedis(MallUser mallUser) {
        MallUserDTO mallUserDTO = new MallUserDTO();
        BeanUtils.copyProperties(mallUser, mallUserDTO);
        mallUserService.insertUserInfoToRedis(mallUserDTO);
    }
}
