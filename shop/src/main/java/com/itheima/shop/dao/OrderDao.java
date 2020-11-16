package com.itheima.shop.dao;

import com.itheima.shop.domain.Order;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.dao.OrderDao
 ****/
public interface OrderDao {
    int add(Order order);

    /***
     * 修改订单状态
     * @param id
     */
    void modifyStatus(String id,int status);

    /***
     * 查找订单
     * @param id
     * @return
     */
    Order findById(String id);
}
