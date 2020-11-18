package com.itheima.shop.decorator.shop;

import com.itheima.shop.domain.Order;
import com.itheima.shop.strategy.shop.MoneyStrategy;
import com.itheima.shop.strategy.shop.StrategyFactory;
import com.itheima.shop.user.ThreadSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 20:45
 **/
@Component(value = "vipMoneySum")
public class VipMoneySum extends DecoratorMoneySum {

    @Autowired
    private ThreadSession threadSession;

    @Autowired
    private StrategyFactory strategyFactory;

    @Override
    public void sum(Order order) {
        super.sum(order);
        money(order);
    }

    //增强
    public void money(Order order) {
        Integer level = threadSession.get().getLevel();
        MoneyStrategy moneyStrategy = strategyFactory.get(level);

        order.setMoneyStrategy(moneyStrategy);
        Integer money = order.getMoneyStrategy().money(order.getPaymoney());
        order.setPaymoney(money);

//        order.setPaymoney(order.getPaymoney() - 10);
    }
}
