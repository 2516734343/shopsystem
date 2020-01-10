package com.muc.service;

import com.muc.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    //   生成自带
    int deleteByPrimaryKey(Integer user_id);
    int insert(UserInfo record);
    int insertSelective(UserInfo record);
    UserInfo selectByPrimaryKey(Integer user_id);
    int updateByPrimaryKeySelective(UserInfo record);
    int updateByPrimaryKey(UserInfo record);
    //   自己加的
    List<UserInfo> selectAll();
}
