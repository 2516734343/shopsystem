package com.muc.action;

import com.muc.bean.ItemsGoodsInfo;
import com.muc.service.ItemsGoodsInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/itemGoods")
public class ItemGoodsAction {
    @Resource
    private ItemsGoodsInfoService itemsGoodsInfoService;

    //前端以显示(方法改为POST) URL-OK(方法为GET) 修改订单里的商品状态 （已收货，待收货，已发货。）
    @RequestMapping(value = "/updateStatus",method =  RequestMethod.POST)
    public int updateStatus( ItemsGoodsInfo itemsGoodsInfo){
        //orderss_id pro_id orderss_status;
        return itemsGoodsInfoService.updateStatus(itemsGoodsInfo);
    }

    //前端以显示(方法改为POST) URL-OK(方法为GET)
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public List<ItemsGoodsInfo> selectAll(){
        return itemsGoodsInfoService.selectAll();
    }

}
