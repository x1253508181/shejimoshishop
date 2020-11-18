package com.itheima.shop.decorator;

import sun.reflect.generics.tree.VoidDescriptor;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 20:23
 **/
public class CocoTea extends DecoratorTea{

    @Override
    public void making() {
        //调用被装饰对象的方法
        super.making();
        //功能增强
        addCoco();
    }
    public void addCoco(){
        System.out.println("增加柚子");

    }


}
