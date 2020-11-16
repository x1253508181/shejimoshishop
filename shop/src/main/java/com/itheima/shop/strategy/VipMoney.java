package com.itheima.shop.strategy;

import com.itheima.shop.domain.Order;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.strategy.MoneySum
 ****/
public interface VipMoney {

    /***
     * 金额计算
     */
    Integer money(Integer money);
}
