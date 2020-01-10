package com.muc.service;

import com.muc.bean.ItemsGoodsInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ItemsGoodsInfoServiceImpl implements ItemsGoodsInfoService{

    @Override
    public int updateStatus(ItemsGoodsInfo record) {
        return 0;
    }

    @Override
    public List<ItemsGoodsInfo> selectAll() {
        return null;
    }
}