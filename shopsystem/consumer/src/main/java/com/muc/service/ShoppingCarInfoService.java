package com.muc.service;

import com.muc.bean.ForUserSeeItem;
import com.muc.bean.ShoppingCarInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "provider",fallback = ShoppingCarInfoServiceImpl.class)
public interface ShoppingCarInfoService {


    //插入一条购物车信息
    @RequestMapping(value = "/shoppingcar/insert",method = RequestMethod.GET)
    int insert(@RequestBody ShoppingCarInfo record);

    //删除一个商品
    @RequestMapping(value = "/shoppingcar/DeleteOneGood",method = RequestMethod.GET)
    int DeleteOneGood(@RequestBody ShoppingCarInfo record);

    //用户下单（删除该用户的购物车的所有商品）
    @RequestMapping(value = "/shoppingcar/UserBuy",method = RequestMethod.GET)
    int UserBy(@RequestParam("user_id") Integer user_id,@RequestParam("userAddressId")  Integer userAddressId);

    //用户查看自己购物车
    @RequestMapping(value = "/shoppingcar/selectByUser",method = RequestMethod.GET)
    List<ShoppingCarInfo> selectByUser(@RequestParam("user_id") Integer user_id);

    //用户修改购物车商品数量
    @RequestMapping(value = "/shoppingcar/updateGoodsNumber",method = RequestMethod.GET)
    int updateGoodsNumber(@RequestBody ShoppingCarInfo record);

    @RequestMapping(value = "/shoppingcar/selectAll",method = RequestMethod.GET)
    List<ShoppingCarInfo> selectAll();
}
