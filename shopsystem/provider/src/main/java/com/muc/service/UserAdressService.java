package com.muc.service;

import com.muc.bean.UserAdress;

import java.util.List;

public interface UserAdressService {
    //   生成自带
    int deleteByPrimaryKey(Integer useraddressid);
    int insert(UserAdress record);
    int insertSelective(UserAdress record);
    UserAdress selectByPrimaryKey(Integer useraddressid);
    int updateByPrimaryKeySelective(UserAdress record);
    int updateByPrimaryKey(UserAdress record);
    //   自己加的
    List<UserAdress> selectByUser(Integer user_id);
    List<UserAdress> selectAll();
}
