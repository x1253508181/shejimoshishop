package com.itheima.shop.decorator;

import com.itheima.shop.domain.Order;
import com.itheima.shop.strategy.StrategyFactory;
import com.itheima.shop.strategy.VipMoney;
import com.itheima.shop.user.SessionThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.decorator.VipOrderMoney
 ****/
@Component(value = "vipOrderMoney")
public class VipOrderMoney extends DecoratorMoneySum {

    @Autowired
    private SessionThreadLocal sessionThreadLocal;

    @Autowired
    private StrategyFactory strategyFactory;

    //价格计算
    @Override
    public void money(Order order) {
        //调用被增强的对象方法
        super.money(order);

        //增强
        vipMoney(order);
    }

    //Vip价格运算
    public void vipMoney(Order order){
        //order.setPaymoney(order.getPaymoney()-5);
        //获取用户等级
        Integer level = sessionThreadLocal.get().getLevel();
        //获取价格优惠策略
        VipMoney vipMoney = strategyFactory.get(level);
        Integer payMoney = vipMoney.money(order.getPaymoney());
        order.setPaymoney(payMoney);
    }
}
