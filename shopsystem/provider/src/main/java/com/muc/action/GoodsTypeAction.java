package com.muc.action;

import com.muc.bean.GoodsType;
import com.muc.service.GoodsTypeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goodsType")
public class GoodsTypeAction {
    @Resource
    private GoodsTypeService goodsTypeService;

    // 增加种类 ok
    @RequestMapping(value = "/insertSelective" ,method = RequestMethod.POST)
    public int insert(@RequestBody GoodsType goodsType){
        int i = goodsTypeService.insert(goodsType);
        return i;
    }

    // 根据id删除种类。ok
    @RequestMapping(value = "/deleteByPrimaryKey" ,method = RequestMethod.GET)
    public int deleteByPrimaryKey(Integer typeid){
        return goodsTypeService.deleteByPrimaryKey(typeid);
    }

    //根据id修改种类名称。 ok
    @RequestMapping(value = "/updateByPrimaryKey" ,method = RequestMethod.POST)
    public int updateByPrimaryKey(@RequestBody GoodsType goodsType){
        return goodsTypeService.updateByPrimaryKey(goodsType);
    }

    //根据id查找种类。ok
    @RequestMapping(value = "/selectByPrimaryKey" ,method = RequestMethod.GET)
    public GoodsType selectByPrimaryKey(Integer typeid){
        return goodsTypeService.selectByPrimaryKey(typeid);
    }

    //查询所有种类 ok
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public List<GoodsType> selectAll(){
        return goodsTypeService.selectAll();
    }


    //以下为用不到的。
    @RequestMapping(value = "/updateByPrimaryKeySelective" ,method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(@RequestBody GoodsType record){
        return goodsTypeService.updateByPrimaryKeySelective(record);
    }
}
