package com.muc.mapper;

import com.muc.bean.ShoppingCarInfo;
import org.apache.ibatis.jdbc.SQL;

public class ShoppingCarInfoSqlProvider {

    public String insertSelective(ShoppingCarInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_cart");
        
        if (record.getUserid() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getGoodid() != null) {
            sql.VALUES("goodid", "#{goodid,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsnumber() != null) {
            sql.VALUES("goodsNumber", "#{goodsnumber,jdbcType=INTEGER}");
        }
        
        if (record.getTocardate() != null) {
            sql.VALUES("toCarDate", "#{tocardate,jdbcType=DATE}");
        }
        
        return sql.toString();
    }
}