package com.muc.service;

import com.muc.bean.ForUserSeeItem;
import com.muc.bean.ItemsGoodsInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "provider",fallback = ItemsGoodsInfoServiceImpl.class)
public interface ItemsGoodsInfoService {

    @RequestMapping(value = "/itemGoods/updateStatus",method =  RequestMethod.GET)
    int updateStatus(@RequestBody ItemsGoodsInfo record);

    @RequestMapping(value = "/itemGoods/selectAll",method = RequestMethod.GET)
    List<ItemsGoodsInfo> selectAll();
}
