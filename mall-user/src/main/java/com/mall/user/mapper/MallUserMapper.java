package com.mall.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.user.model.entity.MallUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaolingfeng
 * @since 2021-02-05
 */
@Mapper
public interface MallUserMapper extends BaseMapper<MallUser> {
    /**
     * description:
     * @author: gaolingfeng
     * @date: 2021/2/7 21:22
     * @param mallUser id、name等查询
     * @return MallUser
     */
    MallUser getMallUser(@Param("userDto") MallUser mallUser);
}
