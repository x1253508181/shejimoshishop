package com.itheima.shop.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.user.Session
 ****/
//共享的用户信息
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class Session {
    private String username;
    private String name;
    private String sex;
    private String role;
    private Integer level;

    //额外操作
    public abstract void handler();
}


//令牌客户端摘要封装--->用户IP、客户端信息--->MD5