package com.muc.service;

import com.muc.bean.GoodsType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Override
    public int insertSelective(GoodsType goodsType) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer typeid) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(GoodsType record) {
        return 0;
    }

    @Override
    public GoodsType selectByPrimaryKey(Integer typeid) {
        return null;
    }

    @Override
    public List<GoodsType> selectAll() {
        return null;
    }

    @Override
    public int insert(GoodsType goodsType) {
        return 20;
    }
}
