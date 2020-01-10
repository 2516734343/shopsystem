package com.muc.mapper;

import com.muc.bean.UserInfo;
import org.apache.ibatis.jdbc.SQL;

public class UserInfoSqlProvider {

    public String insertSelective(UserInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("users");
        
        if (record.getUserid() != null) {
            sql.VALUES("user_Id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("user_Name", "#{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getUserpass() != null) {
            sql.VALUES("user_pass", "#{user_pass,jdbcType=VARCHAR}");
        }
        
        if (record.getUseridentitycard() != null) {
            sql.VALUES("user_Tel", "#{user_tel,jdbcType=VARCHAR}");
        }
        
        if (record.getUserwechatnumber() != null) {
            sql.VALUES("user_Email", "#{user_email,jdbcType=VARCHAR}");
        }
        
        if (record.getUsersex() != null) {
            sql.VALUES("user_Sex", "#{user_sex,jdbcType=CHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("users");
        
        if (record.getUsername() != null) {
            sql.SET("user_Name = #{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getUserpass() != null) {
            sql.SET("user_pass = #{user_pass,jdbcType=VARCHAR}");
        }
        
        if (record.getUseridentitycard() != null) {
            sql.SET("user_Tel = #{user_tel,jdbcType=VARCHAR}");
        }
        
        if (record.getUserwechatnumber() != null) {
            sql.SET("user_Email = #{user_email,jdbcType=VARCHAR}");
        }
        
        if (record.getUsersex() != null) {
            sql.SET("user_Sex = #{user_sex,jdbcType=CHAR}");
        }
        
        sql.WHERE("user_Id = #{user_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}