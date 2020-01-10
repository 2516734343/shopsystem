package com.muc.bean;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
public class UserAdress implements Serializable {
    private Integer useraddressid;

    private Integer user_id;

    private String userreceiveaddress;

    private String userreceivename;

    private String userreceivephone;

    private static final long serialVersionUID = 1L;

    public Integer getUseraddressid() {
        return useraddressid;
    }

    public void setUseraddressid(Integer useraddressid) {
        this.useraddressid = useraddressid;
    }

    public Integer getUserid() {
        return user_id;
    }

    public void setUserid(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUserreceiveaddress() {
        return userreceiveaddress;
    }

    public void setUserreceiveaddress(String userreceiveaddress) {
        this.userreceiveaddress = userreceiveaddress == null ? null : userreceiveaddress.trim();
    }

    public String getUserreceivename() {
        return userreceivename;
    }

    public void setUserreceivename(String userreceivename) {
        this.userreceivename = userreceivename == null ? null : userreceivename.trim();
    }

    public String getUserreceivephone() {
        return userreceivephone;
    }

    public void setUserreceivephone(String userreceivephone) {
        this.userreceivephone = userreceivephone == null ? null : userreceivephone.trim();
    }
}