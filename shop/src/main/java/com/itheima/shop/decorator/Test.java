package com.itheima.shop.decorator;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 20:21
 **/
public class Test {
    public static void main(String[] args) {
        Tea iceTea = new IceTea();

        DecoratorTea peachTea = new PeachTea();
        peachTea.setTea(iceTea);

        peachTea.making();

        DecoratorTea cocoTea = new CocoTea();
        cocoTea.setTea(peachTea);
        cocoTea.making();
    }
}
