package com.itheima.shop.service.impl;

import com.itheima.shop.dao.OrderDao;
import com.itheima.shop.domain.Order;
import com.itheima.shop.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.service.impl.PayServiceImpl
 ****/
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private OrderDao orderDao;

    /***
     * 支付
     * @param type
     * @param id
     */
    @Override
    public void pay(String type, String id) {
        //查询订单
        Order order = orderDao.findById(id);

        //支付-》

        //修改订单状态 0未支付，1已支付
        orderDao.modifyStatus(id,1);

        //改变订单状态，通知发货
    }
}
