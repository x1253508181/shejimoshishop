package com.itheima.shop.user;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-16 22:17
 **/
public class ThreadSession {

    //ThreadLocal 只能存一个对象
    private static ThreadLocal<Session> sessions = new ThreadLocal<Session>();

    //存储
    public void add(Session sessionShare){
        //map->key 当前线程
        sessions.set(sessionShare);
    }
    //获取
    public Session get(){
        return sessions.get();
    }

    //删除
    public void remove(){
        sessions.remove();
    }
}
