package com.muc.mapper;

import com.muc.bean.GoodsInfo;
import org.apache.ibatis.jdbc.SQL;

public class GoodsInfoSqlProvider {

    public String insertSelective(GoodsInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product");
        
        if (record.getGoodsid() != null) {
            sql.VALUES("pro_Id", "#{pro_id,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsname() != null) {
            sql.VALUES("pro_Name", "#{pro_name,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodstype() != null) {
            sql.VALUES("goodsType", "#{goodstype,jdbcType=INTEGER}");
        }
        
        if (record.getGoodssellprice() != null) {
            sql.VALUES("pro_Sell", "#{pro_sell,jdbcType=REAL}");
        }
        
        if (record.getGoodsinputprice() != null) {
            sql.VALUES("pro_Cost", "#{pro_cost,jdbcType=REAL}");
        }
        
        if (record.getGoodsallnumber() != null) {
            sql.VALUES("pro_All", "#{pro_all,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsleftnumber() != null) {
            sql.VALUES("pro_Left", "#{pro_left,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GoodsInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("product");
        
        if (record.getGoodsname() != null) {
            sql.SET("pro_Name = #{pro_name,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodstype() != null) {
            sql.SET("goodsType = #{goodstype,jdbcType=INTEGER}");
        }
        
        if (record.getGoodssellprice() != null) {
            sql.SET("pro_Sell = #{pro_sell,jdbcType=REAL}");
        }
        
        if (record.getGoodsinputprice() != null) {
            sql.SET("pro_Cost = #{pro_cost,jdbcType=REAL}");
        }
        
        if (record.getGoodsallnumber() != null) {
            sql.SET("pro_All = #{pro_all,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsleftnumber() != null) {
            sql.SET("pro_Left = #{pro_left,jdbcType=INTEGER}");
        }
        
        sql.WHERE("pro_Id = #{pro_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}