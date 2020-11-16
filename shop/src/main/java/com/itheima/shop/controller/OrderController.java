package com.itheima.shop.controller;

import com.itheima.shop.domain.Order;
import com.itheima.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.controller.OrderController
 ****/
@Slf4j
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /****
     * 添加订单
     */
    @PostMapping(value = "/add")
    public String add(@RequestBody Order order){
        //添加订单
        int count = orderService.add(order);
        return "SUCCESS";
    }

    /***
     * 取消订单
     */
    @PutMapping(value = "/cancel/{id}")
    public String cancelOrder(@PathVariable(value = "id")String id){
        //取消订单
        orderService.cancelOrder(id);
        return "SUCCESS";
    }

}
