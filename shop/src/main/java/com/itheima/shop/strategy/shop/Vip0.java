package com.itheima.shop.strategy.shop;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 21:15
 **/
@Component(value = "vip0")
public class Vip0 implements MoneyStrategy {
    @Override
    public Integer money(Integer money) {
        return money;
    }
}
