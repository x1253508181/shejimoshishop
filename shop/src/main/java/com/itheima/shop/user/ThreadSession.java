package com.itheima.shop.user;

import org.springframework.stereotype.Component;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.user.TheadSession
 ****/
//用于管理用户共享的信息
@Component
public class ThreadSession {

    //1.创建ThreadLocal->只能存一个对象
    private static ThreadLocal<Session> sessions = new ThreadLocal<Session>();

    //2.添加
    public void add(Session session){
        sessions.set(session);
    }

    //3.获取信息
    public Session get(){
        return sessions.get();
    }

    //4.移除信息
    public void remove(){
        sessions.remove();
    }
}
