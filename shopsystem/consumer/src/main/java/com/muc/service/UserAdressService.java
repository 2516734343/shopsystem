package com.muc.service;

import com.muc.bean.ShoppingCarInfo;
import com.muc.bean.UserAdress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "provider",fallback =UserAdressServiceImpl.class)
public interface UserAdressService {

    //   生成自带
    @RequestMapping(value = "/userAddress/deleteByPrimaryKey",method = RequestMethod.GET)
    int deleteByPrimaryKey(@RequestParam("useraddressid") Integer useraddressid);

    @RequestMapping(value = "/userAddress/insert",method = RequestMethod.GET)
    int insert(@RequestBody UserAdress record);

    @RequestMapping(value = "/userAddress/selectByPrimaryKey",method = RequestMethod.GET)
    UserAdress selectByPrimaryKey(@RequestParam("useraddressid") Integer useraddressid);

    @RequestMapping(value = "/userAddress/updateByPrimaryKeySelective",method = RequestMethod.GET)
    int updateByPrimaryKeySelective(@RequestBody UserAdress record);

    //   自己加的
    @RequestMapping(value = "/userAddress/selectByUser",method = RequestMethod.GET)
    List<UserAdress> selectByUser(@RequestParam("user_id") Integer user_id);

    @RequestMapping(value = "/userAddress/selectAll",method = RequestMethod.GET)
    List<UserAdress> selectAll();
    //用不上
//    @RequestMapping(value = "/userAddress/insertSelective",method = RequestMethod.GET)
//    int insertSelective(UserAdress record);
//    @RequestMapping(value = "/userAddress/updateByPrimaryKey",method = RequestMethod.GET)
//    int updateByPrimaryKey(UserAdress record);
}
