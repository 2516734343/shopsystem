package com.muc.service;

import com.muc.bean.ShoppingCarInfo;

import java.util.List;

public interface ShoppingCarInfoService {
    //   生成自带
    int insert(ShoppingCarInfo record);
    int insertSelective(ShoppingCarInfo record);

    //删除一个商品
    int DeleteOneGood(ShoppingCarInfo record);

    //用户下单（删除该用户的购物车的所有商品）
    int UserBy(Integer user_id,Integer userAddressId);

    //用户查看自己购物车
    List<ShoppingCarInfo> selectByUser(Integer user_id);
    //用户修改购物车商品数量
    int updateGoodsNumber(ShoppingCarInfo record);
    List<ShoppingCarInfo> selectAll();
    //检查库存
    List<ShoppingCarInfo> forCheckLeft(Integer user_id);
}
