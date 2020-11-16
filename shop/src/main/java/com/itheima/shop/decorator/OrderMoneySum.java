package com.itheima.shop.decorator;

import com.itheima.shop.dao.ItemDao;
import com.itheima.shop.domain.Item;
import com.itheima.shop.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.decorator.OrderMoneySum
 ****/
@Component(value = "orderMoneySum")
public class OrderMoneySum implements MoneySum {

    @Autowired
    private ItemDao itemDao;

    /***
     * 订单金额计算、初始的结算金额计算
     * @param order
     */
    @Override
    public void sum(Order order) {
        //查询商品信息
        Item item = itemDao.findById(order.getItemId());

        //计算金额
        order.setMoney(item.getPrice()*order.getNum());
        order.setPaymoney(item.getPrice()*order.getNum());
    }
}
