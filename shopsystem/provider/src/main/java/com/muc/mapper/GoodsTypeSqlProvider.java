package com.muc.mapper;

import com.muc.bean.GoodsType;
import org.apache.ibatis.jdbc.SQL;

public class GoodsTypeSqlProvider {

    public String insertSelective(GoodsType record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("goodstype");
        
        if (record.getTypeid() != null) {
            sql.VALUES("typeId", "#{typeid,jdbcType=INTEGER}");
        }
        
        if (record.getTypename() != null) {
            sql.VALUES("typeName", "#{typename,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GoodsType record) {
        SQL sql = new SQL();
        sql.UPDATE("goodstype");
        
        if (record.getTypename() != null) {
            sql.SET("typeName = #{typename,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("typeId = #{typeid,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}