package com.muc.service;

import com.muc.bean.GoodsInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Override
    public int deleteByPrimaryKey(Integer pro_id) {
        return 0;
    }

    @Override
    public int insert(GoodsInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(GoodsInfo record) {
        return 0;
    }

    @Override
    public GoodsInfo selectByPrimaryKey(Integer pro_id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(GoodsInfo record) {
        return 0;
    }

    @Override
    public List<GoodsInfo> selectAll() {
        return null;
    }

    @Override
    public int inputGoods(Integer id, Integer number, float price) {
        return 0;
    }

}
