package com.muc.bean;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.Date;
@Configuration
public class ShoppingCarInfo implements Serializable {
    private Integer user_id;

    private Integer goodid;

    private Integer goodsnumber;

    private Date tocardate;

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return user_id;
    }

    public void setUserid(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getGoodsnumber() {
        return goodsnumber;
    }

    public void setGoodsnumber(Integer goodsnumber) {
        this.goodsnumber = goodsnumber;
    }

//    public String getTocardate() {
//        return new SimpleDateFormat("yyyy-MM-dd").format(tocardate);
//    }
public Date getTocardate() {
    return tocardate;
}
    public void setTocardate(Date tocardate) {
        this.tocardate = tocardate;
    }
}