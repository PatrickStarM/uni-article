package com.mth.article.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * @description:
 * @author: mth
 * @date: 2022/3/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;
    private String wxOpenId;
    private String phone;
    private String password;
    private String nickname;
    private String avatar;

    //性别 0男 1女 3保密
    private Integer gender;
    private LocalDate birthday;
    private String address;
    private Date createTime;
}
