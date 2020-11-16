package com.itheima.shop.decorator;

import com.itheima.shop.domain.Order;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.decorator.DecoratorMoneySum
 ****/
public abstract class DecoratorMoneySum implements MoneySum{

    //把被装饰者对象作为一个属性注入进来
    private MoneySum moneySum;

    public void setMoneySum(MoneySum moneySum) {
        this.moneySum = moneySum;
    }

    @Override
    public void sum(Order order) {
        //调用被装饰的对象的指定方法
        moneySum.sum(order);
    }
}
