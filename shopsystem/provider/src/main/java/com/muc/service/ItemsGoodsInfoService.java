package com.muc.service;

import com.muc.bean.ItemsGoodsInfo;

import java.util.List;

public interface ItemsGoodsInfoService {
    //   生成自带
    int deleteByPrimaryKey(Integer orderss_info);
    int insert(ItemsGoodsInfo record);
    int insertSelective(ItemsGoodsInfo record);
    ItemsGoodsInfo selectByPrimaryKey(Integer orderss_info);
    int updateByPrimaryKeySelective(ItemsGoodsInfo record);
    int updateByPrimaryKey(ItemsGoodsInfo record);

    //   自己加的
    int updateStatus(ItemsGoodsInfo record);
    List<ItemsGoodsInfo> selectAll();

    //没用 这是有问题的方法。
    List<ItemsGoodsInfo> findAll(Integer orderss_id);


}
