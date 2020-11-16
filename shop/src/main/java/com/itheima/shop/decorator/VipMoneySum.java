package com.itheima.shop.decorator;

import com.itheima.shop.domain.Order;
import com.itheima.shop.strategy.Strategy;
import com.itheima.shop.strategy.StrategyFactory;
import com.itheima.shop.user.ThreadSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.decorator.VipMoneySum
 ****/
@Component(value = "vipMoneySum")
public class VipMoneySum extends DecoratorMoneySum {

    //把策略模式引入进来即可
    @Autowired
    private StrategyFactory strategyFactory;

    @Autowired
    private ThreadSession threadSession;

    //价格计算
    @Override
    public void sum(Order order) {
        //调用父类中的方法
        super.sum(order);
        //功能扩展--结合策略模式一起使用--对应等级->获得策略->计算价格
        //order.setPaymoney(order.getPaymoney()-5);
        Strategy strategy = strategyFactory.get(threadSession.get().getLevel());
        order.setPaymoney(strategy.money(order.getPaymoney()));
    }
}
