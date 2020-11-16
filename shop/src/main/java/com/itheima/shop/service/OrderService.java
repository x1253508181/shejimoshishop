package com.itheima.shop.service;

import com.itheima.shop.domain.Order;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.service.OrderService
 ****/
public interface OrderService {
    /***
     * 添加订单
     * @param order
     */
    int add(Order order);

    /***
     * 取消订单
     * @param id
     */
    void cancelOrder(String id);
}
