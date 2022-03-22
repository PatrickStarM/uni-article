package com.mth.article.service.impl;

import com.mth.article.mapper.UserMapper;
import com.mth.article.model.dto.LoginDto;
import com.mth.article.model.entity.User;
import com.mth.article.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: mth
 * @date: 2022/3/22
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(LoginDto loginDto) {
        User user = getUser((loginDto.getPhone()));
        if (user != null) {
            //对客户端传送的密码进行加密后，和数据库中的密文比对
            return DigestUtils.md5Hex(loginDto.getPassword()).equals(user.getPassword());
        }
        return false;
    }

    @Override
    public User getUser(String phone) {
        return userMapper.findUserByPhone(phone);
    }
}
