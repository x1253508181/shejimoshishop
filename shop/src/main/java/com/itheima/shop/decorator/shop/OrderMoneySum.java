package com.itheima.shop.decorator.shop;

import com.itheima.shop.dao.ItemDao;
import com.itheima.shop.domain.Item;
import com.itheima.shop.domain.Order;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 20:28
 **/
@Component("orderMoneySum")
public class OrderMoneySum implements MoneySum {
    private ItemDao itemDao;

    /**
     * 订单价格计算
     * 满减 100-5
     * VIP -10
     */
    @Override
    public void sum(Order order) {
        //订单金额 商品个数*商品单价
        Item item = itemDao.findById(order.getItemId());
        order.setMoney(item.getPrice() * order.getNum());

        //优惠之后的金额
        order.setPaymoney(item.getPrice() * order.getNum());
    }
}
