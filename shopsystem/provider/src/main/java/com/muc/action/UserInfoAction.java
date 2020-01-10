package com.muc.action;

import com.muc.bean.UserAdress;
import com.muc.bean.UserInfo;
import com.muc.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/userInfo")
public class UserInfoAction {
    @Resource
    private UserInfoService userInfoService;

    //OK  插入用户信息
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(@RequestBody UserInfo userInfo){
    //String user_name,String pass,String card,String wechatnumber,String sex
        return userInfoService.insert(userInfo);
    }

    //OK  根据用户id删除用户信息
    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.GET)
    public int deleteByPrimaryKey(Integer user_id){
        return userInfoService.deleteByPrimaryKey(user_id);
    }

    //OK 修改用户信息
    @RequestMapping(value = "/updateByPrimaryKeySelective",method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(@RequestBody UserInfo userInfo){
    //Integer id,String user_name,String pass,String card,String wechatnumber,String sex
        return userInfoService.updateByPrimaryKeySelective(userInfo);
    }

    //OK  根据用户id查询用户信息。
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public UserInfo selectByPrimaryKey(Integer user_id){
        return userInfoService.selectByPrimaryKey(user_id);
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public List<UserInfo> selectAll(){
        return userInfoService.selectAll();
    }

    //用不着
    public int insertSelective(UserInfo record){
        return userInfoService.insertSelective(record);
    }
    public int updateByPrimaryKey(UserInfo record){
        return  userInfoService.updateByPrimaryKey(record);
    }
}
