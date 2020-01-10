package com.muc.service;

import com.muc.bean.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    //   生成自带
    int deleteByPrimaryKey(Integer typeid);
    int insert(GoodsType record);
    int insertSelective(GoodsType record);
    GoodsType selectByPrimaryKey(Integer typeid);
    int updateByPrimaryKeySelective(GoodsType record);
    int updateByPrimaryKey(GoodsType record);
    //   自己加的
    List<GoodsType> selectAll();
}
