package com.mth.article.service;

import com.mth.article.model.dto.LoginDto;
import com.mth.article.model.entity.User;

/**
 * @description:
 * @author: mth
 * @date: 2022/3/22
 **/
public interface UserService {
    /**
     * 登录
     * @param loginDto 登录dto对象
     * @return 登录结果
     */
    boolean login(LoginDto loginDto);

    /**
     * 根据手机号查找用户
     * @param phone 手机号
     * @return user
     */
    User getUser(String phone);
}
