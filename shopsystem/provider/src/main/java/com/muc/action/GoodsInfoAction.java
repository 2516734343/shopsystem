package com.muc.action;

import com.muc.bean.GoodsInfo;
import com.muc.service.GoodsInfoService;
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

    // 根据货物id删除。ok
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.GET)
    public int deleteByPrimaryKey(Integer pro_id){
        return goodsInfoService.deleteByPrimaryKey(pro_id);
    }

    //插入商品货物 ok
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insert(@RequestBody GoodsInfo goodsInfo){
        return goodsInfoService.insert(goodsInfo);
    }

    //根据货物id查询该货物全部信息 ok
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public GoodsInfo selectByPrimaryKey(Integer pro_id){
        return  goodsInfoService.selectByPrimaryKey(pro_id);
    }

    //根据货物id修改（不能有字段为空） ok
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public  int updateByPrimaryKey(@RequestBody GoodsInfo goodsInfo)
    {
        return goodsInfoService.updateByPrimaryKeySelective(goodsInfo);
    }

    //查询所有的商品信息。ok
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<GoodsInfo> selectAll(){
        return goodsInfoService.selectAll();
    }

    //进货 ok
    @RequestMapping(value = "/inputGoods",method = RequestMethod.GET)
    public int inputGoods(Integer id, Integer number, float price){
      return   goodsInfoService.inputGoods(id,number,price);
    }


    //用不上

    //插入商品货物（有一定的字段为空的插入）
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    public int insertSelective(@RequestBody GoodsInfo record){
        return  goodsInfoService.insertSelective(record);
    }
    //根据货物id修改（可以存在字段为空）
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(@RequestBody GoodsInfo record){
        return goodsInfoService.updateByPrimaryKeySelective(record);
    }
}
