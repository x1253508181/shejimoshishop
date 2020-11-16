package com.itheima.shop.dao;

import com.itheima.shop.domain.Item;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.dao.ItemDao
 ****/
public interface ItemDao {
    /***
     * 修改商品库存
     * @param count
     * @param id
     * @return
     */
    int modify(Integer count,String id);

    /***
     * 根据ID查找商品
     * @param id
     * @return
     */
    Item findById(String id);
}
