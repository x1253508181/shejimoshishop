package com.itheima.shop.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.strategy.StrategyFactory
 ****/
@ConfigurationProperties(prefix = "strategy")
@Component(value = "strategyFactory")
public class StrategyFactory {

    /***
     * 1.定义一个容器对象（Map）->存储所有策略对象ApplicationContext
     *  vip1 --->new Vip1()
     *  vip2 --->new Vip2()
     *  vip3 --->new Vip3()
     */
    @Autowired
    private ApplicationContext act;

    private Map<Integer,String> vipmap;

    //2.提供一个方法用于根据等级获取指定策略
    public Strategy get(Integer level){
        //建立等级和容器中策略的映射关系
        //1 - vip1
        //2 - vip2
        //3 - vip3
        String id = vipmap.get(level);
        return act.getBean(id,Strategy.class);
    }

    public void setVipmap(Map<Integer, String> vipmap) {
        this.vipmap = vipmap;
    }
}
