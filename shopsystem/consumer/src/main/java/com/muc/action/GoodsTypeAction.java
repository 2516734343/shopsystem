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

    //前端以实现   OK 增加种类
    @RequestMapping(value = "/insertSelective" ,method = RequestMethod.POST)
    public int insertSelective(GoodsType goodsType){
        int i = goodsTypeService.insertSelective(goodsType);
        return i;
    }
    //前端以实现 OK 根据id删除种类。
    @RequestMapping(value = "/deleteByPrimaryKey" ,method = RequestMethod.POST)
    public int deleteByPrimaryKey(Integer typeid){
        return goodsTypeService.deleteByPrimaryKey(typeid);
    }

    //前端以实现 OK 根据id修改种类名称。
    @RequestMapping(value = "/updateByPrimaryKey" ,method = RequestMethod.POST)
    public int updateByPrimaryKey(GoodsType goodsType){
        return goodsTypeService.updateByPrimaryKey(goodsType);
    }

    //前端以实现 OK 查询所有种类
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public List<GoodsType> selectAll(){
        return goodsTypeService.selectAll();
    }

    //OK 根据id查找种类。
    @RequestMapping(value = "/selectByPrimaryKey" ,method = RequestMethod.GET)
    public GoodsType selectByPrimaryKey(Integer typeid){
        return goodsTypeService.selectByPrimaryKey(typeid);
    }

}
