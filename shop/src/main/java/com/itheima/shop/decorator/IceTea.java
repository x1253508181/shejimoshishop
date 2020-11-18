package com.itheima.shop.decorator;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 20:19
 **/
public class IceTea implements Tea {

    @Override
    public void making() {
        System.out.println("制作一杯冰水！");
    }
}
