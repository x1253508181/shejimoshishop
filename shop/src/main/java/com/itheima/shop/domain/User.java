package com.itheima.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.domain.User
 ****/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private String username;
    private String password;
    private String sex;
    private String role;
    private Integer level;
}
