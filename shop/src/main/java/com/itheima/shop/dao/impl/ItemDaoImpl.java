package com.itheima.shop.dao.impl;

import com.itheima.shop.dao.ItemDao;
import com.itheima.shop.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.dao.impl.ItemDaoImpl
 ****/
@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /***
     * 修改商品库存
     */
    @Override
    public int modify(Integer count,String id){
        return jdbcTemplate.update("UPDATE item SET count=count-? WHERE id=?",count,id);
    }

    /***
     * 根据ID查询商品详情
     * @param id
     * @return
     */
    @Override
    public Item findById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM item WHERE id=?",new BeanPropertyRowMapper<Item>(Item.class),id);
    }
}
