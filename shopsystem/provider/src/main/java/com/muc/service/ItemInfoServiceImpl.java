package com.muc.service;

import com.muc.bean.ForUserSeeItem;
import com.muc.bean.GoodsInfo;
import com.muc.bean.ItemInfo;
import com.muc.bean.ItemsGoodsInfo;
import com.muc.mapper.GoodsInfoMapper;
import com.muc.mapper.ItemInfoMapper;
import com.muc.mapper.ItemsGoodsInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//要对外暴露出一个接口
@Service("itemInfoService")
public class ItemInfoServiceImpl implements ItemInfoService{
    @Resource
    private ItemInfoMapper itemInfoMapper;
    @Resource
    private ItemsGoodsInfoMapper itemsGoodsInfoMapper;
    @Resource
    private GoodsInfoMapper goodsInfoMapper;
    @Resource
    private List<ForUserSeeItem> forUserSeeItemList;


    @Override
    public int deleteByPrimaryKey(Integer orderss_id) {
        return itemInfoMapper.deleteByPrimaryKey(orderss_id);
    }

    @Override
    public int insert(ItemInfo record) {
        return itemInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ItemInfo record) {
        return itemInfoMapper.insertSelective(record);
    }

    @Override
    public ItemInfo selectByPrimaryKey(Integer orderss_id) {
        return itemInfoMapper.selectByPrimaryKey(orderss_id);
    }

    @Override
    public int updateByPrimaryKeySelective(ItemInfo record) {
        return itemInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ItemInfo record) {
        return itemInfoMapper.updateByPrimaryKey(record);
    }

    //这个方法有错误。
    @Override
    public List<ForUserSeeItem> findAll(Integer user_id) {
        //根据用户id找到用户已经购买的订单

        List<ItemInfo> infoList= itemInfoMapper.findIdByUserId(user_id);

        //进入了该用户购买的所有订单
        for(ItemInfo a:infoList){
            List<ItemsGoodsInfo> itemsGoodsInfos=itemsGoodsInfoMapper.findAll(a.getItemid());
            System.out.println("进入一个订单");
            //进入一个订单的所有商品.
            for(ItemsGoodsInfo b:itemsGoodsInfos){
                //这里使用注入的forUserSeeItem 和  生成的c 是不一样的
                ForUserSeeItem c=new ForUserSeeItem();
                System.out.println("进入一个商品");
                c.setGoodsname(goodsInfoMapper.selectNameById(b.getGoodsid()).getGoodsname());
                c.setGoodsNumber(b.getGoodssellnumber());
                c.setGoodsStatus(b.getGoodsstatus());
                c.setGoodsSellPrice(b.getGoodssellprice());
                System.out.println(c.getGoodsname()+c.getGoodsStatus()+c.getGoodsNumber()+c.getGoodsSellPrice());
                //对每个商品进行添加。
                forUserSeeItemList.add(c);
                System.out.println("添加成功!");
            }
        }
        for(ForUserSeeItem a:forUserSeeItemList){
            System.out.println(a.getGoodsname()+"sssssssssssss");
        }
        return forUserSeeItemList;
    }

    @Override
    public List<ItemInfo> selectAll() {
        return itemInfoMapper.selectAll();
    }

    public List<ForUserSeeItem> findAllBuy(Integer user_id){
        List<ForUserSeeItem> itemsGoodsInfos=new ArrayList<>();

        //根据userid查询到该用户买的订单id
        List<ItemInfo> infoList= itemInfoMapper.findIdByUserId(user_id);
        for(ItemInfo a:infoList){
            //得到了这个订单里面的所有商品信息，并添加到自定义的要用户看的类中。
            itemsGoodsInfos.addAll(itemsGoodsInfoMapper.findAllBuy(a.getItemid()));
        }
        return itemsGoodsInfos;
    }

}
