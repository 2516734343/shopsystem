package com.muc.service;

import com.muc.bean.UserAdress;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserAdressServiceImpl implements UserAdressService{
    @Override
    public int deleteByPrimaryKey(Integer useraddressid) {
        return 0;
    }

    @Override
    public int insert(UserAdress record) {
        return 0;
    }

    @Override
    public UserAdress selectByPrimaryKey(Integer useraddressid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserAdress record) {
        return 0;
    }

    @Override
    public List<UserAdress> selectByUser(Integer user_id) {
        return null;
    }

    @Override
    public List<UserAdress> selectAll() {
        return null;
    }

}