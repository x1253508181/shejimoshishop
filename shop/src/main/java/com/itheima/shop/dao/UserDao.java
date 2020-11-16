package com.itheima.shop.dao;

import com.itheima.shop.domain.User;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.dao.UserDao
 ****/
public interface UserDao {
    /***
     * 根据username查询用户
     * @param username
     * @return
     */
    User findByUserName(String username);

    /***
     * 修改用户金币
     * @param username
     * @param remaining
     */
    void modifyGold(String username, int remaining);
}
