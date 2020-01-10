package com.muc.service;

import com.muc.bean.GoodsInfo;
import com.muc.bean.ItemInfo;
import com.muc.bean.ItemsGoodsInfo;
import com.muc.bean.ShoppingCarInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ShoppingCarInfoServiceImpl implements ShoppingCarInfoService{
    @Override
    public int insert(ShoppingCarInfo record) {
        return 0;
    }

    @Override
    public int DeleteOneGood(ShoppingCarInfo record) {
        return 0;
    }

    @Override
    public int UserBy(Integer user_id, Integer userAddressId) {
        return 0;
    }

    @Override
    public List<ShoppingCarInfo> selectByUser(Integer user_id) {
        return null;
    }

    @Override
    public int updateGoodsNumber(ShoppingCarInfo record) {
        return 0;
    }

    @Override
    public List<ShoppingCarInfo> selectAll() {
        return null;
    }

//    @Override
//    public List<ShoppingCarInfo> forCheckLeft(Integer user_id) {
//        return null;
//    }
}