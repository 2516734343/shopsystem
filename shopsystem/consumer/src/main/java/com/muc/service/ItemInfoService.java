package com.muc.service;

import com.muc.bean.ForUserSeeItem;
import com.muc.bean.ItemInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "provider",fallback = ItemInfoServiceImpl.class)
public interface ItemInfoService {
    //订单信息应该做的
    //用户下单时,新增一条商品信息。
    //用户根据自己的id查看自己已经购买的所有商品信息。


    //插入一条订单信息  ok
    @RequestMapping(value = "/itemInfo/insert",method = RequestMethod.GET)
    int insert(@RequestBody ItemInfo record);

    //这个方法是可行的。
    //根据id,查看所有已经购买的商品  ok
    @RequestMapping(value = "/itemInfo/selectAllBuy",method = RequestMethod.GET)
    List<ForUserSeeItem> findAllBuy(@RequestParam("user_id") Integer user_id);

    @RequestMapping(value = "/itemInfo/selectAll",method = RequestMethod.GET)
    List<ItemInfo> selectAll();
}
