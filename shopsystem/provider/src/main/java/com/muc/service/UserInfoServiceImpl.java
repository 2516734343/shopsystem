package com.muc.service;

import com.muc.bean.UserInfo;
import com.muc.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer user_id) {
        return userInfoMapper.deleteByPrimaryKey(user_id);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer user_id) {
        return userInfoMapper.selectByPrimaryKey(user_id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }
}
