package com.muc.bean;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
public class GoodsInfo implements Serializable {
    private Integer pro_id;

    private String pro_name;

    private Integer goodstype;

    private Float pro_sell;

    private Float pro_cost;

    private Integer pro_all;

    private Integer pro_left;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsid() {
        return pro_id;
    }

    public void setGoodsid(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public String getGoodsname() {
        return pro_name;
    }

    public void setGoodsname(String pro_name) {
        this.pro_name = pro_name == null ? null : pro_name.trim();
    }

    public Integer getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(Integer goodstype) {
        this.goodstype = goodstype;
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

    public Integer getGoodsallnumber() {
        return pro_all;
    }

    public void setGoodsallnumber(Integer pro_all) {
        this.pro_all = pro_all;
    }

    public Integer getGoodsleftnumber() {
        return pro_left;
    }

    public void setGoodsleftnumber(Integer pro_left) {
        this.pro_left = pro_left;
    }
}