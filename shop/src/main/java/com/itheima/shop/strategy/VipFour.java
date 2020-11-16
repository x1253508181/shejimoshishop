package com.itheima.shop.strategy;

import org.springframework.stereotype.Component;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.strategy.VipOne
 ****/
@Component(value = "vipFour")
public class VipFour implements VipMoney {

    //Vip4价格计算
    @Override
    public Integer money(Integer money) {
        return (int)(money*0.1);
    }
}
