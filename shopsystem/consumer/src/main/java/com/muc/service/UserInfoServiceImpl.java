package com.muc.service;

import com.muc.bean.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserInfoServiceImpl implements UserInfoService{
    @Override
    public int deleteByPrimaryKey(Integer user_id) {
        return 0;
    }

    @Override
    public int insert(UserInfo record) {
        return 0;
    }

    @Override
    public List<UserInfo> selectAll() {
        return null;
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer user_id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return 0;
    }
}