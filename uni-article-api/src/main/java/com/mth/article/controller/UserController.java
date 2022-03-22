package com.mth.article.controller;

import com.mth.article.common.ResponseResult;
import com.mth.article.common.ResultCode;
import com.mth.article.model.dto.LoginDto;
import com.mth.article.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: mth
 * @date: 2022/3/22
 **/
@RestController
@RequestMapping(value = "api/v1/users")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseResult login(@RequestBody LoginDto loginDto) {
        log.info("loginDto:" + loginDto);
        boolean flag = userService.login(loginDto);
        if (flag) {
            return ResponseResult.success(userService.getUser(loginDto.getPhone()));
        } else {
            return ResponseResult.failure(ResultCode.USER_SIGN_IN_FAIL);
        }
    }
}
