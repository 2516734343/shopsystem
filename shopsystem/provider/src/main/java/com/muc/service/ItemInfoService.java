package com.muc.service;

import com.muc.bean.ForUserSeeItem;
import com.muc.bean.ItemInfo;

import java.util.List;

public interface ItemInfoService {
    //   生成自带
    int deleteByPrimaryKey(Integer orderss_id);
    int insert(ItemInfo record);
    int insertSelective(ItemInfo record);
    ItemInfo selectByPrimaryKey(Integer orderss_id);
    int updateByPrimaryKeySelective(ItemInfo record);
    int updateByPrimaryKey(ItemInfo record);
    //   自己加的
    List<ForUserSeeItem> findAllBuy(Integer user_id);
    List<ForUserSeeItem> findAll(Integer user_id);

    List<ItemInfo> selectAll();

}
