package com.itheima.shop.service.impl;

import com.itheima.shop.dao.OrderDao;
import com.itheima.shop.decorator.DecoratorMoneySum;
import com.itheima.shop.decorator.MoneySum;
import com.itheima.shop.domain.Order;
import com.itheima.shop.service.ItemService;
import com.itheima.shop.service.OrderService;
import com.itheima.shop.user.ThreadSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.service.impl.OrderServiceImpl
 ****/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ThreadSession threadSession;

    //①基础价格运算->订单价格、结算价格计算
    @Autowired
    private MoneySum orderMoneySum;

    //②计算满减
    @Autowired
    private DecoratorMoneySum fullMoneySum;

    //③Vip再减
    @Autowired
    private DecoratorMoneySum vipMoneySum;

    /***
     * 添加订单
     * @param order
     */
    @Override
    public int add(Order order) {
        //order.setUsername("wangwu");
        order.setPaymoney(100); //结算价格
        order.setMoney(100);  //订单价格

        //获取用户信息
        order.setUsername(threadSession.get().getUsername());
        //装饰者模式嵌套运算计算价格
        fullMoneySum.setMoneySum(orderMoneySum);
        vipMoneySum.setMoneySum(fullMoneySum);
        //价格计算
        vipMoneySum.sum(order);

        //修改库存
        int mCount = itemService.modify(order.getNum(), order.getItemId());
        //添加订单
        int addCount = orderDao.add(order);
        return addCount;
    }

    /***
     * 取消订单
     * @param id
     */
    @Override
    public void cancelOrder(String id) {
        //修改订单状态
        Order order = orderDao.findById(id);
        orderDao.modifyStatus(id,2);

        //改变订单状态
    }





}
