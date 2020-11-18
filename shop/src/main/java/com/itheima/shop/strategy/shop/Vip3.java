package com.itheima.shop.strategy.shop;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 21:15
 **/
@Component(value = "vip3")
public class Vip3 implements MoneyStrategy {
    @Override
    public Integer money(Integer money) {
        return money - 50;
    }
}
