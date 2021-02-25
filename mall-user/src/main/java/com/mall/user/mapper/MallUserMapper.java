package com.mall.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.user.model.dto.MallUserDTO;
import com.mall.user.model.entity.MallUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * 只能查询用户自己信息
     * @author: gaolingfeng
     * @date: 2021/2/7 21:22
     * @param mallUserDTO id、name等查询
     * @return MallUser
     */
    MallUserDTO getUserSelfInfo(@Param("mallUserDTO") MallUserDTO mallUserDTO);

    /**
     * 查询用户信息
     * @author: gaolingfeng
     * @date: 2021/2/25 23:39
     * @param mallUserDTO 筛选条件
     * @return List<MallUserDTO>
     */
    List<MallUserDTO> queryUserInfo(@Param("mallUserDTO")MallUserDTO mallUserDTO);

}
