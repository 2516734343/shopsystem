package com.muc.action;

import com.muc.bean.ShoppingCarInfo;
import com.muc.bean.UserAdress;
import com.muc.service.UserAdressService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/userAddress")
public class UserAddressAction {
    @Resource
    private UserAdressService userAdressService;


    //前端以显示(方法改为POST) URL-OK(方法为GET) 插入一条
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert( UserAdress userAdress){
        //user_id   userreceiveaddress  userreceivename  userreceivephone
        return  userAdressService.insert(userAdress);
    }

    //前端以显示(方法改为POST) URL-OK(方法为GET) 删除
    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.POST)
    public int deleteByPrimaryKey(Integer useraddressid){
        return userAdressService.deleteByPrimaryKey(useraddressid);
    }

    //前端以显示(方法改为POST) URL-OK(方法为GET)  修改
    @RequestMapping(value = "/updateByPrimaryKeySelective",method = RequestMethod.POST)
    public  int updateByPrimaryKeySelective(UserAdress userAdress){
        //useraddressid   userreceiveaddress  userreceivename  userreceivephone
        return userAdressService.updateByPrimaryKeySelective(userAdress);
    }


    // 前端以显示(方法改为POST) URL-OK(方法为GET)
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public List<UserAdress> selectAll(){
        return userAdressService.selectAll();
    }


    //OK 根据用户id查找该用户的所有地址。
    @RequestMapping(value = "/selectByUser",method = RequestMethod.GET)
    public List<UserAdress> selectByUser(Integer user_id){
        return userAdressService.selectByUser(user_id);
    }

    //OK 查找
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public  UserAdress selectByPrimaryKey(Integer useraddressid){
        return userAdressService.selectByPrimaryKey(useraddressid);
    }
}
