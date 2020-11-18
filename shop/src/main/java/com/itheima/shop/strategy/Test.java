package com.itheima.shop.strategy;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 21:11
 **/
public class Test {

    public static void main(String[] args) {

        VipMoneySum vipMoneySum = new VipMoneySum();
        vipMoneySum.setMoney(1000);

        //指定等级，获取策略
        Strategy strategy = StrategyFactory.get(1);
        vipMoneySum.setStrategy(strategy);
        vipMoneySum.getStrategy().money(vipMoneySum.getMoney());
    }

}
