package com.itheima.shop.decorator;

import com.itheima.shop.domain.Order;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.decorator.MoneySum
 ****/
public interface MoneySum {

    //计算订单金额【结算金额、订单金额】
    void sum(Order order);
}
