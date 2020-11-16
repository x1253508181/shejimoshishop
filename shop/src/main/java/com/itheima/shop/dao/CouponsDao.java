package com.itheima.shop.dao;

import com.itheima.shop.domain.Coupons;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.dao.CouponsDao
 ****/
public interface CouponsDao {
    /***
     * 查询用户有效的优惠券
     * @param id
     * @param username
     * @return
     */
    Coupons findByIdAndUserName(String id, String username);

    /***
     * 修改指定优惠券状态
     * @param id
     */
    void modifyCouponsStatus(String id);
}
