package com.itheima.shop.strategy;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 21:07
 **/
public class Vip2 implements Strategy {
    @Override
    public Integer money(Integer money) {
        return money-100;
    }
}
