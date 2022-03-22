package com.mth.article.mapper;

import com.mth.article.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: mth
 * @date: 2022/3/22
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void insert() throws Exception{
        User user = User.builder()
                .phone("17606186124")
                .password("123456")
                .nickname("派大星")
                .avatar("http://www.patrickstarm.top/wp-content/uploads/2021/07/派大星.jpg")
                .gender(0)
                .birthday(LocalDate.now())
                .address("江苏南京")
                .createTime(new Date())
                .build();
        userMapper.insert(user);
    }

    @Test
    void findUserByPhone() throws Exception{
        User user = userMapper.findUserByPhone("17606186124");
        assertNotNull(user);
        log.info(String.valueOf(user));
    }
}