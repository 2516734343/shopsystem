package com.muc.bean;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.Date;

@Configuration
public class ItemInfo implements Serializable {
    private Integer orderss_id;

    private Integer orderss_userid;

    private Integer orderss_receiveinfo;

    private Date orderss_buydate;

    private static final long serialVersionUID = 1L;

    public Integer getItemid() {
        return orderss_id;
    }

    public void setItemid(Integer orderss_id) {
        this.orderss_id = orderss_id;
    }

    public Integer getItemuserid() {
        return orderss_userid;
    }

    public void setItemuserid(Integer orderss_userid) {
        this.orderss_userid = orderss_userid;
    }

    public Integer getItemreceiveinfo() {
        return orderss_receiveinfo;
    }

    public void setItemreceiveinfo(Integer orderss_receiveinfo) {
        this.orderss_receiveinfo = orderss_receiveinfo;
    }

    public Date getItembuydate() {
        return orderss_buydate;
    }

    public void setItembuydate(Date orderss_buydate) {
        this.orderss_buydate = orderss_buydate;
    }
}