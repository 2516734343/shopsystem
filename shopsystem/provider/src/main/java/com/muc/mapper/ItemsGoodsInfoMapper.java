package com.muc.mapper;

import com.muc.bean.ForUserSeeItem;
import com.muc.bean.ItemsGoodsInfo;
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

public interface ItemsGoodsInfoMapper {
    @Delete({
        "delete from orderssinfo",
        "where orderss_Info = #{orderss_info,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderss_info);

    @Insert({
        "insert into orderssinfo ( Orderss_Id, ",
        "pro_Id, orderss_Status, ",
        "pro_Sell, pro_Cost, ",
        "orderss_SellNumber)",
        "values ( #{orderss_id,jdbcType=INTEGER}, ",
        "#{pro_id,jdbcType=INTEGER}, '未发货', ",
        "#{pro_sell,jdbcType=REAL}, #{pro_cost,jdbcType=REAL}, ",
        "#{orderss_sellnumber,jdbcType=INTEGER})"
    })
    int insert(ItemsGoodsInfo record);

    @InsertProvider(type=ItemsGoodsInfoSqlProvider.class, method="insertSelective")
    int insertSelective(ItemsGoodsInfo record);

    @Select({
        "select",
        "orderss_Info, Orderss_Id, pro_Id, orderss_Status, pro_Sell, pro_Cost, ",
        "orderss_SellNumber",
        "from orderssinfo",
        "where orderss_Info = #{orderss_info,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="orderss_Info", property="orderss_info", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Orderss_Id", property="orderss_id", jdbcType=JdbcType.INTEGER),
        @Result(column="pro_Id", property="pro_id", jdbcType=JdbcType.INTEGER),
        @Result(column="orderss_Status", property="orderss_status", jdbcType=JdbcType.CHAR),
        @Result(column="pro_Sell", property="pro_sell", jdbcType=JdbcType.REAL),
        @Result(column="pro_Cost", property="pro_cost", jdbcType=JdbcType.REAL),
        @Result(column="orderss_SellNumber", property="orderss_sellnumber", jdbcType=JdbcType.INTEGER)
    })
    ItemsGoodsInfo selectByPrimaryKey(Integer orderss_info);

    @UpdateProvider(type=ItemsGoodsInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ItemsGoodsInfo record);

    @Update({
        "update orderssinfo",
        "set Orderss_Id = #{orderss_id,jdbcType=INTEGER},",
          "pro_Id = #{pro_id,jdbcType=INTEGER},",
          "orderss_Status = #{orderss_status,jdbcType=CHAR},",
          "pro_Sell = #{pro_sell,jdbcType=REAL},",
          "pro_Cost = #{pro_cost,jdbcType=REAL},",
          "orderss_SellNumber = #{orderss_sellnumber,jdbcType=INTEGER}",
        "where orderss_Info = #{orderss_info,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ItemsGoodsInfo record);

    @Select({
            "select",
            "pro_Id,orderss_Status,orderss_SellNumber,pro_Sell",
            "from orderssinfo",
            "where Orderss_Id=#{orderss_id,jdbcType=INTEGER}"
    })
    List<ItemsGoodsInfo> findAll(Integer orderss_id);

    @Select({
            "select",
            "product.pro_Name,orderssinfo.orderss_Status,orderssinfo.orderss_SellNumber,orderssinfo.pro_Sell",
            "from orderssinfo,product",
            "where product.pro_Id=orderssinfo.pro_Id and Orderss_Id=#{orderss_id,jdbcType=INTEGER}"
    })
    List<ForUserSeeItem> findAllBuy(Integer orderss_id);

    @Update({
            "update orderssinfo set orderss_Status=#{orderss_status,jdbcType=CHAR} ",
            "where Orderss_Id=#{orderss_id,jdbcType=INTEGER} and pro_Id=#{pro_id,jdbcType=INTEGER} "
    })
    int updateStatus(ItemsGoodsInfo record);

    @Select({
            "select",
            "orderss_Info, Orderss_Id, pro_Id, orderss_Status, pro_Sell, pro_Cost, ",
            "orderss_SellNumber",
            "from orderssinfo",
    })
    List<ItemsGoodsInfo> selectAll();
}