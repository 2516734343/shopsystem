package com.muc.service;

import com.muc.bean.GoodsInfo;

import java.util.List;

public interface GoodsInfoService {
    //   生成自带
    int deleteByPrimaryKey(Integer pro_id);
    int insert(GoodsInfo record);
    int insertSelective(GoodsInfo record);
    GoodsInfo selectByPrimaryKey(Integer pro_id);
    int updateByPrimaryKeySelective(GoodsInfo record);
    int updateByPrimaryKey(GoodsInfo record);

    //   自己加的
    List<GoodsInfo> selectAll();
    int inputGoods(Integer id,Integer number,float price);

    int selectLeftById(Integer pro_id);
    int updateLeftById(Integer id,Integer number);
}
