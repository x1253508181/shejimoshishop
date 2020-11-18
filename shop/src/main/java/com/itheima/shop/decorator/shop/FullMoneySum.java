package com.itheima.shop.decorator.shop;

import com.itheima.shop.domain.Order;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 20:31
 **/
@Component(value = "fullMoneySum")
public class FullMoneySum extends DecoratorMoneySum {

    @Override
    public void sum(Order order) {
        super.sum(order);
        money(order);
    }

    //扩展
    public void money(Order order) {
        if (order.getMoney() >= 100) {
            order.setPaymoney(order.getPaymoney() - 5);
        }
    }
}
