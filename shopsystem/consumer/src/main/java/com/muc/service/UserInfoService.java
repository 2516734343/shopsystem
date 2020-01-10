package com.muc.service;

import com.muc.bean.UserAdress;
import com.muc.bean.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "provider",fallback =UserInfoServiceImpl.class)
public interface UserInfoService {

    //   生成自带
    @RequestMapping(value = "/userInfo/deleteByPrimaryKey",method = RequestMethod.GET)
    int deleteByPrimaryKey(@RequestParam("user_id") Integer user_id);

    @RequestMapping(value = "/userInfo/selectByPrimaryKey",method = RequestMethod.GET)
    UserInfo selectByPrimaryKey(@RequestParam("user_id") Integer user_id);

    @RequestMapping(value = "/userInfo/updateByPrimaryKeySelective",method = RequestMethod.GET)
    int updateByPrimaryKeySelective(@RequestBody UserInfo record);

    @RequestMapping(value = "/userInfo/insert",method = RequestMethod.GET)
    int insert(@RequestBody UserInfo record);

    @RequestMapping(value = "/userInfo/selectAll",method = RequestMethod.GET)
    List<UserInfo> selectAll();
    //   自己加的
}
