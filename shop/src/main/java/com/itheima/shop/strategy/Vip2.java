package com.itheima.shop.strategy;

import org.springframework.stereotype.Component;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.strategy.Vip1
 ****/
@Component(value = "vip2")
public class Vip2 implements Strategy {

    /***
     * Vip1
     * @param money
     * @return
     */
    @Override
    public Integer money(Integer money) {
        return money-5;
    }
}
