package com.muc.service;

import com.muc.bean.UserAdress;
import com.muc.mapper.UserAdressMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userAdressService")
public class UserAdressServiceImpl implements UserAdressService{
    @Resource
    private UserAdressMapper userAdressMapper;

    @Override
    public int deleteByPrimaryKey(Integer useraddressid) {
        return userAdressMapper.deleteByPrimaryKey(useraddressid);
    }

    @Override
    public int insert(UserAdress record) {
        return userAdressMapper.insert(record);
    }

    @Override
    public int insertSelective(UserAdress record) {
        return userAdressMapper.insertSelective(record);
    }

    @Override
    public UserAdress selectByPrimaryKey(Integer useraddressid) {
        return userAdressMapper.selectByPrimaryKey(useraddressid);
    }

    @Override
    public int updateByPrimaryKeySelective(UserAdress record) {
        return userAdressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserAdress record) {
        return userAdressMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserAdress> selectByUser(Integer user_id) {
        return userAdressMapper.selectByUser(user_id);
    }

    @Override
    public List<UserAdress> selectAll() {
        return userAdressMapper.selectAll();
    }
}
