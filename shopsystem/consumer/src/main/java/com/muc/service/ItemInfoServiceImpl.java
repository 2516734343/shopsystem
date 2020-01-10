package com.muc.service;

import com.muc.bean.ForUserSeeItem;
import com.muc.bean.ItemInfo;
import com.muc.bean.ItemsGoodsInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//要对外暴露出一个接口
@Component
public class ItemInfoServiceImpl implements ItemInfoService{

    @Override
    public int insert(ItemInfo record) {
        return 0;
    }

    @Override
    public List<ForUserSeeItem> findAllBuy(Integer user_id) {
        return null;
    }

    @Override
    public List<ItemInfo> selectAll() {
        return null;
    }
}