package com.itheima.shop.strategy;

import org.springframework.stereotype.Component;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.strategy.VipOne
 ****/
@Component(value = "vipOne")
public class VipOne implements VipMoney {

    //Vip1价格计算
    @Override
    public Integer money(Integer money) {
        return money;
    }
}
