package com.itheima.shop.decorator;

import com.itheima.shop.domain.Order;
import org.springframework.stereotype.Component;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.decorator.FullMoneySum
 ****/
@Component(value = "fullMoneySum")
public class FullMoneySum extends DecoratorMoneySum {


    @Override
    public void sum(Order order) {
        //调用父类的方法
        super.sum(order);

        //满100-5
        if(order.getPaymoney()>=100){
            order.setPaymoney(order.getPaymoney()-10);
        }
    }
}
