package com.itheima.shop.decorator;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 20:19
 **/
public class DecoratorTea implements Tea {

    private Tea tea;

    public void setTea(Tea tea) {
        this.tea = tea;
    }

    @Override
    public void making() {
        tea.making();
    }
}
