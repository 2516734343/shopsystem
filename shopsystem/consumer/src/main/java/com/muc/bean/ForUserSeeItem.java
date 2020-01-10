package com.muc.bean;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
public class ForUserSeeItem   implements Serializable {
    private String pro_name;
    private Integer goodsNumber;
    private String goodsStatus;
    private Float goodsSellPrice;

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
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Float getGoodsSellPrice() {
        return goodsSellPrice;
    }

    public void setGoodsSellPrice(float goodsSellPrice) {
        this.goodsSellPrice = goodsSellPrice;
    }


}
