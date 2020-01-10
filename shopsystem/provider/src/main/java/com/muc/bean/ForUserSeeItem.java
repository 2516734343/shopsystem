package com.muc.bean;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
public class ForUserSeeItem   implements Serializable {
    private String pro_name;
    private Integer goodsNumber;
    private String orderss_Status;
    private Float pro_Sell;

    private static final long serialVersionUID = 1L;

    public String getGoodsname() {
        return pro_name;
    }

    public void setGoodsname(String pro_name) {
        this.pro_name = pro_name;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsStatus() {
        return orderss_Status;
    }

    public void setGoodsStatus(String orderss_Status) {
        this.orderss_Status = orderss_Status;
    }

    public Float getGoodsSellPrice() {
        return pro_Sell;
    }

    public void setGoodsSellPrice(float pro_Sell) {
        this.pro_Sell = pro_Sell;
    }


}
