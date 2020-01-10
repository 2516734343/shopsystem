package com.muc.service;

import com.muc.bean.GoodsInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value="provider",fallback = GoodsInfoServiceImpl.class)
public interface GoodsInfoService {

    //1.增加新的商品
    @RequestMapping(value = "/goodsInfo/insert", method = RequestMethod.POST)
    public int insert(@RequestBody GoodsInfo record);
    // 2.进货
    @RequestMapping(value = "/goodsInfo/inputGoods", method = RequestMethod.GET)
    public int inputGoods(@RequestParam("id") Integer id, @RequestParam("number") Integer number, @RequestParam("price") float price);
    //3.删除一行的商品
    @RequestMapping(value = "/goodsInfo/deleteByPrimaryKey", method = RequestMethod.GET)
    public int deleteByPrimaryKey(@RequestParam("pro_id") Integer pro_id);
    // 4.修改商品的种类,售价,名称
    @RequestMapping(value = "/goodsInfo/updateByPrimaryKey", method = RequestMethod.POST)
    public int updateByPrimaryKey(@RequestBody GoodsInfo record);
    //5.根据商品名称(id)查找商品,
    @RequestMapping(value = "/goodsInfo/selectByPrimaryKey", method = RequestMethod.GET)
    public GoodsInfo selectByPrimaryKey(@RequestParam("pro_id") Integer pro_id);
    //7.查找全部商品。
    @RequestMapping(value = "/goodsInfo/selectAll", method = RequestMethod.GET)
    public  List<GoodsInfo> selectAll();

//    int updateByPrimaryKeySelective(GoodsInfo goodsInfo);


//    //用不上
    @RequestMapping(value = "/goodsInfo/insertSelective", method = RequestMethod.GET)
    public int insertSelective(GoodsInfo record);
    @RequestMapping(value = "/goodsInfo/updateByPrimaryKeySelective", method = RequestMethod.GET)
    public int updateByPrimaryKeySelective(GoodsInfo record);
}
