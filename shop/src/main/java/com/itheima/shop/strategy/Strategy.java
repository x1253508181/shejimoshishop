package com.itheima.shop.strategy;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.strategy.Strategy
 ****/
public interface Strategy {

    /***
     * 策略要做的事情 计算金额
     */
    Integer money(Integer money);
}
