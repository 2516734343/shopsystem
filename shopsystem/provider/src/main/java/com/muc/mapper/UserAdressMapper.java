package com.muc.mapper;

import com.muc.bean.UserAdress;
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

public interface UserAdressMapper {
    @Delete({
        "delete from users_addr",
        "where userAddressId = #{useraddressid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer useraddressid);

    @Insert({
        "insert into users_addr ( user_Id, ",
        "userReceiveAddress, userReceiveName, ",
        "userReceivephone)",
        "values ( #{user_id,jdbcType=INTEGER}, ",
        "#{userreceiveaddress,jdbcType=VARCHAR}, #{userreceivename,jdbcType=VARCHAR}, ",
        "#{userreceivephone,jdbcType=VARCHAR})"
    })
    int insert(UserAdress record);

    @InsertProvider(type=UserAdressSqlProvider.class, method="insertSelective")
    int insertSelective(UserAdress record);

    @Select({
        "select",
        "userAddressId, user_Id, userReceiveAddress, userReceiveName, userReceivephone",
        "from users_addr",
        "where userAddressId = #{useraddressid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="userAddressId", property="useraddressid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_Id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="userReceiveAddress", property="userreceiveaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="userReceiveName", property="userreceivename", jdbcType=JdbcType.VARCHAR),
        @Result(column="userReceivephone", property="userreceivephone", jdbcType=JdbcType.VARCHAR)
    })
    UserAdress selectByPrimaryKey(Integer useraddressid);

    @UpdateProvider(type=UserAdressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserAdress record);

    @Update({
        "update users_addr",
        "set user_Id = #{user_id,jdbcType=INTEGER},",
          "userReceiveAddress = #{userreceiveaddress,jdbcType=VARCHAR},",
          "userReceiveName = #{userreceivename,jdbcType=VARCHAR},",
          "userReceivephone = #{userreceivephone,jdbcType=VARCHAR}",
        "where userAddressId = #{useraddressid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserAdress record);


    @Select({
            "select",
            "userAddressId, user_Id, userReceiveAddress, userReceiveName, userReceivephone",
            "from users_addr",
            "where user_Id = #{useid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="userAddressId", property="useraddressid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="user_Id", property="user_id", jdbcType=JdbcType.INTEGER),
            @Result(column="userReceiveAddress", property="userreceiveaddress", jdbcType=JdbcType.VARCHAR),
            @Result(column="userReceiveName", property="userreceivename", jdbcType=JdbcType.VARCHAR),
            @Result(column="userReceivephone", property="userreceivephone", jdbcType=JdbcType.VARCHAR)
    })
    List<UserAdress> selectByUser(Integer user_id);

    @Select({
            "select",
            "userAddressId, user_Id, userReceiveAddress, userReceiveName, userReceivephone",
            "from users_addr"
    })
    List<UserAdress> selectAll();
}