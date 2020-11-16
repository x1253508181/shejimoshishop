package com.itheima.shop.strategy;

import org.springframework.stereotype.Component;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.strategy.Vip1
 ****/
@Component(value = "vip1")
public class Vip1 implements Strategy {

    /***
     * Vip1
     * @param money
     * @return
     */
    @Override
    public Integer money(Integer money) {
        return money;
    }
}
