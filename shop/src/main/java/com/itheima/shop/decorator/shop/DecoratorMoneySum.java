package com.itheima.shop.decorator.shop;

import com.itheima.shop.domain.Order;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 20:42
 **/
public class DecoratorMoneySum implements MoneySum {
    private MoneySum moneySum;

    public void setMoneySum(MoneySum moneySum) {
        this.moneySum = moneySum;
    }

    @Override
    public void sum(Order order) {
        moneySum.sum(order);
    }
}
