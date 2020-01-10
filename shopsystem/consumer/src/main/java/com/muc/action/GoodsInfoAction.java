package com.muc.action;

import com.muc.bean.GoodsInfo;
import com.muc.service.GoodsInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goodsInfo")
public class GoodsInfoAction {
    @Resource
    private GoodsInfoService goodsInfoService;

    //(方法改为POST) 根据货物id删除。
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.POST)
    public int deleteByPrimaryKey(Integer pro_id){
        return goodsInfoService.deleteByPrimaryKey(pro_id);
    }

    //插入商品货物
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insert(GoodsInfo goodsInfo){
        int i=goodsInfoService.insert(goodsInfo);
        Map<String, Object> model = new HashMap<>();
        model.put("time", new Date());
        return i;
    }

    //根据货物id修改（不能有字段为空）
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public  int updateByPrimaryKey(GoodsInfo goodsInfo)
    {
        return goodsInfoService.updateByPrimaryKeySelective(goodsInfo);
    }

    //查询所有的商品信息。
    @RequestMapping(value = "/selectAll", method = RequestMethod.POST)
    public List<GoodsInfo> selectAll(){
        return goodsInfoService.selectAll();
    }

    //进货
    @RequestMapping(value = "/inputGoods",method = RequestMethod.POST)
    public int inputGoods(Integer id, Integer number, float price){
        return   goodsInfoService.inputGoods(id,number,price);
    }


    //根据货物id查询该货物全部信息
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.POST)
    public GoodsInfo selectByPrimaryKey(Integer pro_id){
        return  goodsInfoService.selectByPrimaryKey(pro_id);
    }

}
