package com.itheima.shop.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.domain.Order
 ****/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order implements Serializable {
    private String itemId;
    private String id;
    //订单金额= 单价*购买数量
    private Integer money;
    //结算金额====计算优惠价格
    private Integer paymoney;
    private Integer status;
    //购买数量
    private Integer num;
    private String username;
    private String couponsId;
}