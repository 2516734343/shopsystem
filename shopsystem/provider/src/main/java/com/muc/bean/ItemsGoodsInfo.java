package com.muc.bean;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
@Configuration
public class ItemsGoodsInfo implements Serializable {
    private Integer orderss_info;

    private Integer orderss_id;

    private Integer pro_id;

    private String orderss_status;

    private Float pro_sell;

    private Float pro_cost;

    private Integer orderss_sellnumber;

    private static final long serialVersionUID = 1L;

    public Integer getItemgoodsinfo() {
        return orderss_info;
    }

    public void setItemgoodsinfo(Integer orderss_info) {
        this.orderss_info = orderss_info;
    }

    public Integer getItemid() {
        return orderss_id;
    }

    public void setItemid(Integer orderss_id) {
        this.orderss_id = orderss_id;
    }

    public Integer getGoodsid() {
        return pro_id;
    }

    public void setGoodsid(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public String getGoodsstatus() {
        return orderss_status;
    }

    public void setGoodsstatus(String orderss_status) {
        this.orderss_status = orderss_status == null ? null : orderss_status.trim();
    }

    public Float getGoodssellprice() {
        return pro_sell;
    }

    public void setGoodssellprice(Float pro_sell) {
        this.pro_sell = pro_sell;
    }

    public Float getGoodsinputprice() {
        return pro_cost;
    }

    public void setGoodsinputprice(Float pro_cost) {
        this.pro_cost = pro_cost;
    }

    public Integer getGoodssellnumber() {
        return orderss_sellnumber;
    }

    public void setGoodssellnumber(Integer orderss_sellnumber) {
        this.orderss_sellnumber = orderss_sellnumber;
    }
}