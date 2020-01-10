package com.muc.mapper;

import com.muc.bean.ItemsGoodsInfo;
import org.apache.ibatis.jdbc.SQL;

public class ItemsGoodsInfoSqlProvider {

    public String insertSelective(ItemsGoodsInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("orderssinfo");
        
        if (record.getItemgoodsinfo() != null) {
            sql.VALUES("orderss_Info", "#{orderss_info,jdbcType=INTEGER}");
        }
        
        if (record.getItemid() != null) {
            sql.VALUES("Orderss_Id", "#{orderss_id,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsid() != null) {
            sql.VALUES("pro_Id", "#{pro_id,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsstatus() != null) {
            sql.VALUES("orderss_Status", "#{orderss_status,jdbcType=CHAR}");
        }
        
        if (record.getGoodssellprice() != null) {
            sql.VALUES("pro_Sell", "#{pro_sell,jdbcType=REAL}");
        }
        
        if (record.getGoodsinputprice() != null) {
            sql.VALUES("pro_Cost", "#{pro_cost,jdbcType=REAL}");
        }
        
        if (record.getGoodssellnumber() != null) {
            sql.VALUES("orderss_SellNumber", "#{orderss_sellnumber,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ItemsGoodsInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("orderssinfo");
        
        if (record.getItemid() != null) {
            sql.SET("Orderss_Id = #{orderss_id,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsid() != null) {
            sql.SET("pro_Id = #{pro_id,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsstatus() != null) {
            sql.SET("orderss_Status = #{orderss_status,jdbcType=CHAR}");
        }
        
        if (record.getGoodssellprice() != null) {
            sql.SET("pro_Sell = #{pro_sell,jdbcType=REAL}");
        }
        
        if (record.getGoodsinputprice() != null) {
            sql.SET("pro_Cost = #{pro_cost,jdbcType=REAL}");
        }
        
        if (record.getGoodssellnumber() != null) {
            sql.SET("orderss_SellNumber = #{orderss_sellnumber,jdbcType=INTEGER}");
        }
        
        sql.WHERE("orderss_Info = #{orderss_info,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}