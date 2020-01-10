package com.muc.action;

import com.muc.bean.ItemInfo;
import com.muc.bean.ShoppingCarInfo;
import com.muc.service.GoodsInfoService;
import com.muc.service.ShoppingCarInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/shoppingcar")
public class ShoppingCarAction {
    @Resource
    private ShoppingCarInfoService shoppingCarInfoService;

    //前端已经实现  OK  插入一条购物车（用户点击了加入购物车）
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(ShoppingCarInfo shoppingCarInfo){
        // user_id pro_id goodsnumber
        return shoppingCarInfoService.insert(shoppingCarInfo);
    }

    //前端以显示(方法改为POST) URL-OK(方法为GET) 用户删除了某条购物车信息
    @RequestMapping(value = "/DeleteOneGood",method = RequestMethod.POST)
    public int DeleteOneGood(ShoppingCarInfo shoppingCarInfo ){
        //goodid user_id
        return shoppingCarInfoService.DeleteOneGood(shoppingCarInfo);
    }

    //前端以显示(方法改为POST) URL-OK(方法为GET) 用户修改自己的购物车商品数量。
    @RequestMapping(value = "/updateGoodsNumber",method = RequestMethod.POST)
    public int updateGoodsNumber(ShoppingCarInfo shoppingCarInfo){
        //user_id,goodid,goodsnumber
        return  shoppingCarInfoService.updateGoodsNumber(shoppingCarInfo);
    }

    // 前端以显示(方法改为POST) URL-OK(方法为GET)
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public List<ShoppingCarInfo> selectAll(){
        return shoppingCarInfoService.selectAll();
    }


    // 前端以显示(方法改为POST) URL-OK(方法为GET)  用户从购物车下单（删除该用户的购物车的所有商品）
    @RequestMapping(value = "/UserBuy",method = RequestMethod.POST)
    public int UserBuy(Integer user_id,Integer userAddressId){
        return shoppingCarInfoService.UserBy(user_id,userAddressId);
    }

    //ok  用户查看自己的购物车
    @RequestMapping(value = "/selectByUser",method = RequestMethod.GET)
    public List<ShoppingCarInfo> selectByUser(Integer user_id){
        return shoppingCarInfoService.selectByUser(user_id);
    }

}
