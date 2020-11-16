package com.itheima.shop.dao.impl;

import com.itheima.shop.dao.UserDao;
import com.itheima.shop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.dao.impl.UserDaoImpl
 ****/
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /***
     * 根据username查询用户
     * @param username
     * @return
     */
    @Override
    public User findByUserName(String username) {
        return jdbcTemplate.queryForObject("select * from user where username=?",new BeanPropertyRowMapper<User>(User.class),username);
    }

    /***
     * 修改用户金币
     * @param username
     * @param remaining
     */
    @Override
    public void modifyGold(String username, int remaining) {
        jdbcTemplate.update("update user set gold=? where username=?",remaining,username);
    }
}
