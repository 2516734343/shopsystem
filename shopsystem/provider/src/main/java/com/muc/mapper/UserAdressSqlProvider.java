package com.muc.mapper;

import com.muc.bean.UserAdress;
import org.apache.ibatis.jdbc.SQL;

public class UserAdressSqlProvider {

    public String insertSelective(UserAdress record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("users_addr");
        
        if (record.getUseraddressid() != null) {
            sql.VALUES("userAddressId", "#{useraddressid,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            sql.VALUES("user_Id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getUserreceiveaddress() != null) {
            sql.VALUES("userReceiveAddress", "#{userreceiveaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getUserreceivename() != null) {
            sql.VALUES("userReceiveName", "#{userreceivename,jdbcType=VARCHAR}");
        }
        
        if (record.getUserreceivephone() != null) {
            sql.VALUES("userReceivephone", "#{userreceivephone,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserAdress record) {
        SQL sql = new SQL();
        sql.UPDATE("users_addr");

        if (record.getUserid() != null) {
            sql.SET("user_Id = #{user_id,jdbcType=INTEGER}");
        }

        if (record.getUserreceiveaddress() != null) {
            sql.SET("userReceiveAddress = #{userreceiveaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getUserreceivename() != null) {
            sql.SET("userReceiveName = #{userreceivename,jdbcType=VARCHAR}");
        }
        
        if (record.getUserreceivephone() != null) {
            sql.SET("userReceivephone = #{userreceivephone,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("userAddressId = #{useraddressid,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}