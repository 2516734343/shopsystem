package com.muc.mapper;

import com.muc.bean.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserInfoMapper {
    @Delete({
        "delete from users",
        "where user_Id = #{user_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer user_id);

    @Insert({
        "insert into users( user_Name, ",
        "user_pass, user_Tel, ",
        "user_Email, user_Sex)",
        "values ( #{user_name,jdbcType=VARCHAR}, ",
        "#{user_pass,jdbcType=VARCHAR}, #{user_tel,jdbcType=VARCHAR}, ",
        "#{user_email,jdbcType=VARCHAR}, #{user_sex,jdbcType=CHAR})"
    })
    int insert(UserInfo record);

    @InsertProvider(type=UserInfoSqlProvider.class, method="insertSelective")
    int insertSelective(UserInfo record);

    @Select({
        "select",
        "user_Id, user_Name, user_pass, user_Tel, user_Email, user_Sex",
        "from users",
        "where user_Id = #{user_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_Id", property="user_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_Name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_pass", property="user_pass", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_Tel", property="user_tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_Email", property="user_email", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_Sex", property="user_sex", jdbcType=JdbcType.CHAR)
    })
    UserInfo selectByPrimaryKey(Integer user_id);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserInfo record);

    @Update({
        "update users",
        "set user_Name = #{user_name,jdbcType=VARCHAR},",
          "user_pass = #{user_pass,jdbcType=VARCHAR},",
          "user_Tel = #{user_tel,jdbcType=VARCHAR},",
          "user_Email = #{user_email,jdbcType=VARCHAR},",
          "user_Sex = #{user_sex,jdbcType=CHAR}",
        "where user_Id = #{user_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserInfo record);

    @Select({
            "select",
            "user_Id, user_Name, user_pass, user_Tel, user_Email, user_Sex",
            "from users"
    })
    List<UserInfo> selectAll();
}