package com.muc.service;

import com.muc.bean.GoodsInfo;
import com.muc.mapper.GoodsInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsInfoService")
public class GoodsInfoServiceImpl implements GoodsInfoService {
    @Resource
    private GoodsInfoMapper goodsInfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer pro_id) {
        return goodsInfoMapper.deleteByPrimaryKey(pro_id);
    }

    @Override
    public int insert(GoodsInfo record) {
        return goodsInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsInfo record) {

        return goodsInfoMapper.insertSelective(record);
    }

    @Override
    public GoodsInfo selectByPrimaryKey(Integer pro_id) {

        return goodsInfoMapper.selectByPrimaryKey(pro_id);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsInfo record) {
        return goodsInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsInfo record) {

        return goodsInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<GoodsInfo> selectAll() {

        return goodsInfoMapper.selectAll();
    }

    @Override
    public int inputGoods(Integer id, Integer number, float price) {
        return goodsInfoMapper.inputGoods(id,number,price);
    }

    @Override
    public int selectLeftById(Integer pro_id) {
        return goodsInfoMapper.selectLeftById(pro_id);
    }

    @Override
    public int updateLeftById(Integer id, Integer number) {
        return goodsInfoMapper.updateLeftById(id,number);
    }
}
