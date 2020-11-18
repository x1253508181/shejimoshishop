package com.itheima.shop.strategy;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 21:10
 **/
public class VipMoneySum {

    private Integer money;
    //制定策略接口对象，用策略实例计算金额
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }


}
