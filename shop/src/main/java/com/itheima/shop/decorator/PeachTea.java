package com.itheima.shop.decorator;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 20:20
 **/
public class PeachTea extends DecoratorTea {

    @Override
    public void making() {
        //先调用父类的making方法 ->执行被装饰对象的方法
        super.making();
        //功能增强
        addPeach();
    }
    public void addPeach(){
        System.out.println("增加桃子");
    }


}
