package com.itheima.shop.strategy.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 21:17
 **/
@Component
@ConfigurationProperties(prefix = "strategy")
public class StrategyFactory {
    @Autowired
    private ApplicationContext act;

    //key 登记  value =act bean中的id
    private Map<Integer, String> strategyMap;

    public void setStrategyMap(Map<Integer, String> strategyMap) {
        this.strategyMap = strategyMap;
    }

    //获取策略
    public MoneyStrategy get(Integer level) {
        //根据登记从strategyMap获取ApplicationContext 实例的id 值
        String key = strategyMap.get(level);
        //根据id值 从容器中 获取策略实例
        return act.getBean(key, MoneyStrategy.class);
    }

}
