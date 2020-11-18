package com.itheima.shop.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: xuebin
 * @create: 2020-11-18 21:08
 **/
public class StrategyFactory {

    private static Map<Integer, Strategy> strategyMap = new HashMap<>();

    //初始化所有策略
    static {
        strategyMap.put(1, new Vip1());
        strategyMap.put(2, new Vip2());
        strategyMap.put(3, new Vip3());
    }

    //获取策略
    public static Strategy get(Integer level) {
        return strategyMap.get(level);
    }



}
