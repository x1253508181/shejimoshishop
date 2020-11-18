package com.itheima.shop.strategy.shop;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 21:15
 **/
@Component(value = "vip1")
public class Vip1 implements MoneyStrategy {
    @Override
    public Integer money(Integer money) {
        return money - 10;
    }
}
