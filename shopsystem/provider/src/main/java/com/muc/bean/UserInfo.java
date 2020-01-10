package com.muc.bean;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
public class UserInfo implements Serializable {
    private Integer user_id;

    private String user_name;

    private String user_pass;

    private String user_tel;

    private String user_email;

    private String user_sex;

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return user_id;
    }

    public void setUserid(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getUserpass() {
        return user_pass;
    }

    public void setUserpass(String user_pass) {
        this.user_pass = user_pass == null ? null : user_pass.trim();
    }

    public String getUseridentitycard() {
        return user_tel;
    }

    public void setUseridentitycard(String user_tel) {
        this.user_tel = user_tel == null ? null : user_tel.trim();
    }

    public String getUserwechatnumber() {
        return user_email;
    }

    public void setUserwechatnumber(String user_email) {
        this.user_email = user_email == null ? null : user_email.trim();
    }

    public String getUsersex() {
        return user_sex;
    }

    public void setUsersex(String user_sex) {
        this.user_sex = user_sex == null ? null : user_sex.trim();
    }
}