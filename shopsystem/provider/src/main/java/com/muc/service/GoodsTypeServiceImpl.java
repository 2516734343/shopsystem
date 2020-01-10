package com.muc.service;

import com.muc.bean.GoodsType;
import com.muc.mapper.GoodsTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsTypeService")
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Resource
    private GoodsTypeMapper goodsTypeMapper;
    @Override
    public int deleteByPrimaryKey(Integer typeid) {
        return goodsTypeMapper.deleteByPrimaryKey(typeid);
    }

    @Override
    public int insert(GoodsType record) {
        return goodsTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsType record) {
        return goodsTypeMapper.insertSelective(record);
    }

    @Override
    public GoodsType selectByPrimaryKey(Integer typeid) {
        return goodsTypeMapper.selectByPrimaryKey(typeid);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsType record) {
        return goodsTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsType record) {
        return goodsTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<GoodsType> selectAll() {
        return goodsTypeMapper.selectAll();
    }
}
