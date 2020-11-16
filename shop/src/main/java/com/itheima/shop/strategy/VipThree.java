package com.itheima.shop.strategy;

import org.springframework.stereotype.Component;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.strategy.VipOne
 ****/
@Component(value = "vipThree")
public class VipThree implements VipMoney {

    //Vip3价格计算
    @Override
    public Integer money(Integer money) {
        return (int)(money*0.5);
    }
}
