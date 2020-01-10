package com.muc.mapper;

import com.muc.bean.ItemInfo;
import org.apache.ibatis.jdbc.SQL;

public class ItemInfoSqlProvider {

    public String insertSelective(ItemInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("orderss");
        
        if (record.getItemid() != null) {
            sql.VALUES("orderss_Id", "#{orderss_id,jdbcType=INTEGER}");
        }
        
        if (record.getItemuserid() != null) {
            sql.VALUES("orderss_UserId", "#{orderss_userid,jdbcType=INTEGER}");
        }
        
        if (record.getItemreceiveinfo() != null) {
            sql.VALUES("orderss_ReceiveInfo", "#{orderss_receiveinfo,jdbcType=INTEGER}");
        }
        
        if (record.getItembuydate() != null) {
            sql.VALUES("orderss_BuyDate", "#{orderss_buydate,jdbcType=DATE}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ItemInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("orderss");
        
        if (record.getItemuserid() != null) {
            sql.SET("orderss_UserId = #{orderss_userid,jdbcType=INTEGER}");
        }
        
        if (record.getItemreceiveinfo() != null) {
            sql.SET("orderss_ReceiveInfo = #{orderss_receiveinfo,jdbcType=INTEGER}");
        }
        
        if (record.getItembuydate() != null) {
            sql.SET("orderss_BuyDate = #{orderss_buydate,jdbcType=DATE}");
        }
        
        sql.WHERE("orderss_Id = #{orderss_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}