package com.muc.service;

import com.muc.bean.ItemsGoodsInfo;
import com.muc.mapper.ItemsGoodsInfoMapper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("itemsGoodsInfoService")
public class ItemsGoodsInfoServiceImpl implements ItemsGoodsInfoService{
    @Resource
    private ItemsGoodsInfoMapper itemsGoodsInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer orderss_info) {
        return itemsGoodsInfoMapper.deleteByPrimaryKey(orderss_info);
    }

    @Override
    public int insert(ItemsGoodsInfo record) {
        return itemsGoodsInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ItemsGoodsInfo record) {
        return itemsGoodsInfoMapper.insertSelective(record);
    }

    @Override
    public ItemsGoodsInfo selectByPrimaryKey(Integer orderss_info) {
        return itemsGoodsInfoMapper.selectByPrimaryKey(orderss_info);
    }

    @Override
    public int updateByPrimaryKeySelective(ItemsGoodsInfo record) {
        return itemsGoodsInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ItemsGoodsInfo record) {
        return itemsGoodsInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ItemsGoodsInfo> findAll(Integer orderss_id) {
        return itemsGoodsInfoMapper.findAll(orderss_id);
    }

    @Override
    public int updateStatus(ItemsGoodsInfo record) {
        return itemsGoodsInfoMapper.updateStatus(record);
    }

    @Override
    public List<ItemsGoodsInfo> selectAll() {
        return itemsGoodsInfoMapper.selectAll();
    }
}
