package com.muc.action;

import com.muc.bean.ForUserSeeItem;
import com.muc.bean.ItemInfo;
import com.muc.bean.ItemsGoodsInfo;
import com.muc.service.ItemInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/itemInfo")
public class ItemInfoAction {
    @Resource
    private ItemInfoService itemInfoService;

    //前端以显示(方法改为POST) URL-OK(方法为GET) 插入一条订单信息
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(ItemInfo itemInfo ){
        //orderss_userid orderss_receiveinfo
        return itemInfoService.insert(itemInfo);
    }

    // 前端以显示(方法改为POST) URL-OK(方法为GET)
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public List<ItemInfo> selectAll(){
        return itemInfoService.selectAll();
    }

    //这个方法是可行的。
    //OK 根据id,查看所有已经购买的商品. 且返回的是用户想要看到的东西。
    @RequestMapping(value = "/selectAllBuy",method = RequestMethod.GET)
    public List<ForUserSeeItem> findAllBuy(Integer user_id){
        return itemInfoService.findAllBuy(user_id);
    }

}
