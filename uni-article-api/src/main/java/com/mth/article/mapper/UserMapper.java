package com.mth.article.mapper;

import com.mth.article.model.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @description:
 * @author: mth
 * @date: 2022/3/22
 **/
public interface UserMapper {
    /**
     * 新增数据，并返回自增主键
     *
     * @param user 入参user对象
     */
    @Insert("INSERT INTO t_user (phone,password,nickname,avatar,gender,birthday,address,create_time) " +
            "VALUES (#{phone}, #{password}, #{nickname}, #{avatar}, #{gender}, #{birthday}, #{address}, #{createTime}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    /**
     * 根据手机号查询用户信息
     *
     * @param phone 手机号
     * @return User 用户对象
     */
    @Select("SELECT * FROM t_user WHERE phone = #{phone}")
    User findUserByPhone(@Param("phone") String phone);

}
