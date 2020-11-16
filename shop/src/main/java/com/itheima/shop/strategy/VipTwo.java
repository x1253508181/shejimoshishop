package com.itheima.shop.strategy;

import org.springframework.stereotype.Component;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.strategy.VipOne
 ****/
@Component(value = "vipTwo")
public class VipTwo implements VipMoney {

    //Vip2价格计算
    @Override
    public Integer money(Integer money) {
        return money-5;
    }
}
