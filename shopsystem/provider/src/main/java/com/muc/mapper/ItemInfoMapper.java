package com.muc.mapper;

import com.muc.bean.ItemInfo;
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

public interface ItemInfoMapper {
    @Delete({
        "delete from orderss",
        "where orderss_Id = #{orderss_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderss_id);

    @Insert({
        "insert into orderss ( orderss_UserId, ",
        "orderss_ReceiveInfo, orderss_BuyDate)",
        "values ( #{orderss_userid,jdbcType=INTEGER}, ",
        "#{orderss_receiveinfo,jdbcType=INTEGER}, curdate() )"
    })
    int insert(ItemInfo record);

    @InsertProvider(type=ItemInfoSqlProvider.class, method="insertSelective")
    int insertSelective(ItemInfo record);

    @Select({
        "select",
        "orderss_Id, orderss_UserId, orderss_ReceiveInfo, orderss_BuyDate",
        "from orderss",
        "where orderss_Id = #{orderss_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="orderss_Id", property="orderss_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="orderss_UserId", property="orderss_userid", jdbcType=JdbcType.INTEGER),
        @Result(column="orderss_ReceiveInfo", property="orderss_receiveinfo", jdbcType=JdbcType.INTEGER),
        @Result(column="orderss_BuyDate", property="orderss_buydate", jdbcType=JdbcType.DATE)
    })
    ItemInfo selectByPrimaryKey(Integer orderss_id);

    @UpdateProvider(type=ItemInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ItemInfo record);

    @Update({
        "update orderss",
        "set orderss_UserId = #{orderss_userid,jdbcType=INTEGER},",
          "orderss_ReceiveInfo = #{orderss_receiveinfo,jdbcType=INTEGER},",
          "orderss_BuyDate = #{orderss_buydate,jdbcType=DATE}",
        "where orderss_Id = #{orderss_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ItemInfo record);

    @Select({
            "select",
            "orderss_Id",
            "from orderss",
            "where itemUserid = #{orderss_userid,jdbcType=INTEGER}",
            "order by orderss_id desc"
    })
    List<ItemInfo> findItemId(Integer orderss_userid);

    @Select({
            "select orderss_Id from orderss where orderss_UserId=#{orderss_userid}"
    })
    List<ItemInfo> findIdByUserId(Integer orderss_userid);

    @Select({
            "select",
            "orderss_Id, orderss_UserId, orderss_ReceiveInfo, orderss_BuyDate",
            "from orderss",
    })
    List<ItemInfo> selectAll();

}