package com.itheima.shop.user;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.user.SessionShare
 ****/
public class SessionShare extends Session {

    //方便创建实例
    public SessionShare(String username, String name, String sex, String role, Integer level) {
        super(username, name, sex, role, level);
    }

    @Override
    public void handler() {
        System.out.println("共享信息！");
    }
}
