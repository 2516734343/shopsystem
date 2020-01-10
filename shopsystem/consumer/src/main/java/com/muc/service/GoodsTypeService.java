package com.muc.service;

import com.muc.bean.GoodsType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "provider",fallback = GoodsTypeServiceImpl.class)
public interface GoodsTypeService {

    //商品种类 增删改查
    // 增加种类 ok
    @RequestMapping(value = "/goodsType/insertSelective" ,method = RequestMethod.GET)
    int insertSelective(@RequestBody GoodsType goodsType);

    // 根据id删除种类。
    @RequestMapping(value = "/goodsType/deleteByPrimaryKey" ,method = RequestMethod.GET)
    int deleteByPrimaryKey(@RequestParam("typeid") Integer typeid);
    //根据id修改种类名称。
    @RequestMapping(value = "/goodsType/updateByPrimaryKey" ,method = RequestMethod.POST)
    int updateByPrimaryKey(@RequestBody GoodsType goodsType);

    //根据id查找种类。
    @RequestMapping(value = "/goodsType/selectByPrimaryKey" ,method = RequestMethod.GET)
    GoodsType selectByPrimaryKey(@RequestParam("typeid") Integer typeid);

    //查询所有种类
    @RequestMapping(value = "/goodsType/selectAll",method = RequestMethod.GET)
    List<GoodsType> selectAll();

    @RequestMapping(value = "/goodsType/insert",method = RequestMethod.POST)
    int insert(@RequestBody GoodsType goodsType);
}
