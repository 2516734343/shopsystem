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

    //前端以实现  OK  插入用户信息
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(UserInfo userInfo){
        //String user_name,String pass,String card,String wechatnumber,String sex
        int i=userInfoService.insert(userInfo);
        return i;
    }

    //前端以实现  OK 根据用户id删除用户信息
    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.POST)
    public int deleteByPrimaryKey(Integer user_id){
        return userInfoService.deleteByPrimaryKey(user_id);
    }

    //前端以实现  OK 修改用户信息
    @RequestMapping(value = "/updateByPrimaryKeySelective",method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(UserInfo userInfo){
        //Integer id,String user_name,String pass,String card,String wechatnumber,String sex
        return userInfoService.updateByPrimaryKeySelective(userInfo);
    }

    //前端以实现  OK
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public List<UserInfo> selectAll(){
        return userInfoService.selectAll();
    }


    //OK 根据用户id查询用户信息。
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public UserInfo selectByPrimaryKey(Integer user_id){
        return userInfoService.selectByPrimaryKey(user_id);
    }

}
