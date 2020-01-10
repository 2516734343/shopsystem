package com.muc.service;

import com.muc.bean.GoodsInfo;
import com.muc.bean.ItemInfo;
import com.muc.bean.ItemsGoodsInfo;
import com.muc.bean.ShoppingCarInfo;
import com.muc.mapper.GoodsInfoMapper;
import com.muc.mapper.ItemInfoMapper;
import com.muc.mapper.ItemsGoodsInfoMapper;
import com.muc.mapper.ShoppingCarInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("shoppingCarInfoService")
public class ShoppingCarInfoServiceImpl implements ShoppingCarInfoService{
    @Resource
    private ShoppingCarInfoMapper shoppingCarInfoMapper;
    @Resource
    private GoodsInfoMapper goodsInfoMapper;
    @Resource
    private ItemInfoMapper itemInfoMapper;
    @Resource
    private ItemsGoodsInfoMapper itemsGoodsInfoMapper;

    @Override
    public int insert(ShoppingCarInfo record) {
        return shoppingCarInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ShoppingCarInfo record) {
        return shoppingCarInfoMapper.insertSelective(record);
    }

    @Override
    public int DeleteOneGood(ShoppingCarInfo record) {
        return shoppingCarInfoMapper.DeleteOneGood(record);
    }

    @Override
    public int UserBy(Integer user_id,Integer userAddressId) {

        //得到该用户的所有购物车信息(购买的商品id，商品数量)
        List<ShoppingCarInfo> goodsIdNumberList;
        goodsIdNumberList=shoppingCarInfoMapper.fromIdFindNumber(user_id);

        System.out.println("得到该用户的所有购物车信息");
        //一一对应，检查库存是否足够。
        //这里本来用的for循环，后自动改为foreach.
        for (ShoppingCarInfo aGoodsIdNumberList : goodsIdNumberList) {
            //在商品表中.通过商品id查商品余量。
            int left = goodsInfoMapper.selectLeftById(aGoodsIdNumberList.getGoodid());
            //如果商品余量小于购买量，即库存不够
            if (left < aGoodsIdNumberList.getGoodsnumber()) {
                return -1;
            }
        }
        System.out.println("库存足够");
        //库存够了。这里做3件事。1.减库存，2.新增订单，订单商品。3.清空购物车。
        //1 遍历减库存
        for(ShoppingCarInfo aGoodsIdNumberList : goodsIdNumberList){
            goodsInfoMapper.updateLeftById(aGoodsIdNumberList.getGoodid(),aGoodsIdNumberList.getGoodsnumber());
        }
        System.out.println("库存已经减少。");
        // return 1;  //用于调试  到这里都是ok的

        //2 新增订单
        ItemInfo a =new ItemInfo();
        a.setItemuserid(user_id);
        a.setItemreceiveinfo(userAddressId);
        itemInfoMapper.insert(a);
        System.out.println("订单新增完成");
        //3.遍历增加订单商品
        List<ItemInfo> itemInfoList=itemInfoMapper.findItemId(user_id);
        System.out.println("找到订单号");
        for(ShoppingCarInfo aGoodsIdNumberList : goodsIdNumberList){
            GoodsInfo goodsInfo= new GoodsInfo();
            //分别得到了商品id,收货数目.商品进价,商品售价。
            ItemsGoodsInfo itemsGoodsInfo = new ItemsGoodsInfo();
            itemsGoodsInfo.setGoodsid(aGoodsIdNumberList.getGoodid());
            itemsGoodsInfo.setGoodssellnumber(aGoodsIdNumberList.getGoodsnumber());
            goodsInfo=goodsInfoMapper.selectByPrimaryKey(aGoodsIdNumberList.getGoodid());
            itemsGoodsInfo.setGoodsinputprice(goodsInfo.getGoodsinputprice());
            itemsGoodsInfo.setGoodssellprice(goodsInfo.getGoodssellprice());
            //下面得到订单id。
            itemsGoodsInfo.setItemid(itemInfoList.get(0).getItemid());
            //可以插入订单商品表了。
            itemsGoodsInfoMapper.insert(itemsGoodsInfo);
            System.out.println("插入一条数据");
        }

        //4.删除购物车内容
        shoppingCarInfoMapper.DeleteAllGoodsByUser(user_id);
        return 1;
    }

    @Override
    public List<ShoppingCarInfo> selectByUser(Integer user_id) {
        return shoppingCarInfoMapper.selectByUser(user_id);
    }

    @Override
    public int updateGoodsNumber(ShoppingCarInfo record) {
        return shoppingCarInfoMapper.updateGoodsNumber(record);
    }

    @Override
    public List<ShoppingCarInfo> selectAll() {
        return shoppingCarInfoMapper.selectAll();
    }

    @Override
    public List<ShoppingCarInfo> forCheckLeft(Integer user_id) {
        return shoppingCarInfoMapper.fromIdFindNumber(user_id);
    }
}
