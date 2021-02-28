package com.mall.user.service.impl;

import com.mall.user.common.sys.MallException;
import com.mall.user.common.util.RedisUtils;
import com.mall.user.mapper.MallUserMapper;
import com.mall.user.mapper.UserAddressMapper;
import com.mall.user.model.dto.MallUserDTO;
import com.mall.user.model.dto.UserAddressDTO;
import com.mall.user.model.entity.MallUser;
import com.mall.user.model.entity.UserAddress;
import com.mall.user.service.MallUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gaolingfeng
 * @since 2021-02-05
 */
@Service
public class MallUserServiceImpl implements MallUserService {

    @Autowired
    private MallUserMapper mallUserMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;

    public static final String REDIS_PREFIX = "mall-user:mall-user:userId";
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void save(MallUser mallUser) {

    }

    @Override
    public void delete(MallUser mallUser) {

    }

    @Override
    public MallUserDTO getUserSelfInfo(Integer userId) {
        // 先查redis，查到了返回，redis没查到就查mysql,将mysql中的值更新到redis
        MallUserDTO mallUserDTO = new MallUserDTO();
        Object redisUser = redisUtils.hashGet(REDIS_PREFIX, String.valueOf(userId));
        if (ObjectUtils.isEmpty(redisUser)) {
            MallUserDTO mallUserDTO1 = new MallUserDTO();
            mallUserDTO1.setUserId(userId);
            mallUserDTO = mallUserMapper.getUserSelfInfo(mallUserDTO1);
            // 根据用户ID查询用户地址
            mallUserDTO.setDetailAddress(this.getUserAddress(userId));
            if(ObjectUtils.isEmpty(mallUserDTO)){
                throw new MallException("程序出现错误,请与管理员联系");
            }
            redisUtils.hashPut(REDIS_PREFIX, String.valueOf(userId), mallUserDTO);
        } else {
            BeanUtils.copyProperties(redisUser, mallUserDTO);
        }
        return mallUserDTO;
    }

    @Override
    public List<MallUserDTO> queryUserInfo(Integer userId, String userName, String realName, String phone) {
        MallUserDTO filterUserDTO = new MallUserDTO(userId,userName,realName,phone);
        // 先查redis所有的key为mall-user:mall-user:userId的value
        Map<Object, Object> redisUserMap = redisUtils.hashGetAll(REDIS_PREFIX);
        List<MallUserDTO> mallUserDTOList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(redisUserMap)){
            for(Object key:redisUserMap.keySet()){
                MallUserDTO mallUserDTO = (MallUserDTO) redisUserMap.get(key);
                mallUserDTOList.add(mallUserDTO);
            }
            return filterRedisUserInfo(filterUserDTO,mallUserDTOList);
        }else {
            // 查数据库
            mallUserDTOList = mallUserMapper.queryUserInfo(filterUserDTO);
            for(MallUserDTO dto:mallUserDTOList){
                dto.setDetailAddress(this.getUserAddress(dto.getUserId()));
            }
            // 存redis
            this.putAllUserToRedis(mallUserDTOList);
            return mallUserDTOList;
        }
    }

    @Override
    public void insertUserInfoToRedis(MallUserDTO mallUserDTO) {
        redisUtils.hashPut(REDIS_PREFIX, String.valueOf(mallUserDTO.getUserId()), mallUserDTO);
    }

    /**
     * 从redis中存取的user信息中筛选
     * @author: gaolingfeng
     * @date: 2021/2/25 22:42
     * @param mallUserDTO 筛选条件
     * @param dtoList 被筛选对象
     * @return List<MallUserDTO>
     */
    private List<MallUserDTO> filterRedisUserInfo(MallUserDTO mallUserDTO, List<MallUserDTO> dtoList){
        List<MallUserDTO> mallUserDTOList = new ArrayList<>();
        for(MallUserDTO dto :dtoList){
            if(StringUtils.isNotEmpty(String.valueOf(mallUserDTO.getUserId()))) {
                Pattern patternUserId = Pattern.compile(String.valueOf(mallUserDTO.getUserId()));
                Matcher matcher = patternUserId.matcher(String.valueOf(dto.getUserId()));
                if(matcher.find()){
                    mallUserDTOList.add(dto );
                    continue;
                }
            }
            if(StringUtils.isNotEmpty(mallUserDTO.getUserName())){
                Pattern patternUserName = Pattern.compile(mallUserDTO.getUserName());
                if(patternUserName.matcher(dto.getUserName()).find()){
                    mallUserDTOList.add(dto );
                    continue;
                }
            }
            if(StringUtils.isNotEmpty(mallUserDTO.getRealName())){
                Pattern patternRealName = Pattern.compile(mallUserDTO.getRealName());
                if(patternRealName.matcher(dto.getRealName()).find()){
                    mallUserDTOList.add(dto );
                    continue;
                }
            }
            if(StringUtils.isNotEmpty(mallUserDTO.getPhone())){
                Pattern patternPhone = Pattern.compile(String.valueOf(mallUserDTO.getRealName()));
                if(patternPhone.matcher(dto.getUserName()).find()){
                    mallUserDTOList.add(dto );
                }
            }
        }
        return mallUserDTOList;
    }

    /**
     * 将数据库中信息批量插入redis
     * @author: gaolingfeng
     * @date: 2021/2/26 0:20
     * @param mallUserDTOS 数据库中信息
     * @return void
     */
    private void putAllUserToRedis(List<MallUserDTO> mallUserDTOS){
        Map<String,Object> redisMap = new HashMap<>(16);
        for(MallUserDTO dto:mallUserDTOS){
            redisMap.put(String.valueOf(dto.getUserId()),dto);
        }
        redisUtils.hashPutAll(REDIS_PREFIX,redisMap);
    }

    /**
     * 查询用户地址信息
     * @param userId 用户id
     * @return UserAddressDTO
     */
    private String getUserAddress(Integer userId){
        Map<String,Object> params = new HashMap<>(1);
        params.put("USER_ID",userId);
        List<UserAddress> userAddress = userAddressMapper.selectByMap(params);
        if(CollectionUtils.isEmpty(userAddress)){
            return null;
        }else {
            UserAddress dto = userAddress.get(0);
            return dto.getAddressProvince()+dto.getAddressCity()+dto.getAddressDistrictorcounty()
                    +dto.getAddressStreetortown()+dto.getAddressDetailed();
        }
    }
}
