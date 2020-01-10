package com.muc.action;

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


    //插入一条  ok
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(@RequestBody UserAdress userAdress){
    //user_id   receiveaddress  receivename  receivephone userAdress
        return  userAdressService.insert(userAdress);
    }

    //删除
    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.GET)
    public int deleteByPrimaryKey(Integer useraddressid){
        return userAdressService.deleteByPrimaryKey(useraddressid);
    }

    //修改  ok
    @RequestMapping(value = "/updateByPrimaryKeySelective",method = RequestMethod.POST)
    public  int updateByPrimaryKeySelective(@RequestBody UserAdress userAdress){
        //user_id   receiveaddress  receivename  receivephone userAdress
        return userAdressService.updateByPrimaryKeySelective(userAdress);
    }

    //查找  ok
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public  UserAdress selectByPrimaryKey(Integer useraddressid){
        return userAdressService.selectByPrimaryKey(useraddressid);
    }

    //根据用户id查找该用户的所有地址。 ok
    @RequestMapping(value = "/selectByUser",method = RequestMethod.GET)
    public List<UserAdress> selectByUser(Integer user_id){
        return userAdressService.selectByUser(user_id);
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public List<UserAdress> selectAll(){
        return userAdressService.selectAll();
    }

    //用不到
//    public int insertSelective(UserAdress record){
//        return userAdressService.insertSelective(record);
//    }
//    public  int updateByPrimaryKey(UserAdress record){
//        return userAdressService.updateByPrimaryKey(record);
//    }
}
