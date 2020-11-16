package com.itheima.shop.controller;

import com.itheima.shop.domain.User;
import com.itheima.shop.service.UserService;
import com.itheima.shop.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.controller.LoginController
 ****/
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserService userService;

    /***
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    public String login(String username,String password) throws Exception {
        //根据用户名查询(不做密码测试)
        User user = userService.findByUserName(username);
        if(user==null){
            return "登录失败！";
        }
        //模拟登录
        Map<String,Object> userMap = new HashMap<String,Object>();
        userMap.put("username",user.getUsername());
        userMap.put("name","王五");
        userMap.put("sex",user.getSex());
        userMap.put("role",user.getRole());
        userMap.put("level",user.getLevel());

        //生成JWT令牌
        String token = JwtTokenUtil.generateTokenUser(UUID.randomUUID().toString(), userMap, 36000000L);
        return token;
    }
}
