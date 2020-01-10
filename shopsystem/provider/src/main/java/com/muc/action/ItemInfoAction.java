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

    //插入一条订单信息  ok
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(@RequestBody ItemInfo itemInfo ){
        //user_id useraddressid
        return itemInfoService.insert(itemInfo);
    }

    //这个方法有bug.
    //根据id,查看所有已经购买的商品
//    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
//    public List<ForUserSeeItem> findAll(Integer user_id){
//       return itemInfoService.findAll(user_id);
//    }

    //这个方法是可行的。
    //根据id,查看所有已经购买的商品  ok
    @RequestMapping(value = "/selectAllBuy",method = RequestMethod.GET)
    public List<ForUserSeeItem> findAllBuy(Integer user_id){
        return itemInfoService.findAllBuy(user_id);
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public List<ItemInfo> selectAll(){
        return itemInfoService.selectAll();
    }
}
