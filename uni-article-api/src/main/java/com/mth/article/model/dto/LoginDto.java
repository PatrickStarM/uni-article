package com.mth.article.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: mth
 * @date: 2022/3/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {
    private String phone;
    private String password;
}
