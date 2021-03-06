package com.mth.article.service;

import com.mth.article.model.dto.LoginDto;
import com.mth.article.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: mth
 * @date: 2022/3/22
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void login() {
        LoginDto loginDto = LoginDto.builder()
                .phone("17606186124")
                .password("123456")
                .build();
        boolean flag = userService.login(loginDto);
        assertTrue(flag);
    }

    @Test
    void getUser() {
        User user = userService.getUser("17606186124");
        assertNotNull(user);
        log.info(String.valueOf(user));
    }
}