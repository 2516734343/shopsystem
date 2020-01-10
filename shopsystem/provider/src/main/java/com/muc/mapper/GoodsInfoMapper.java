package com.muc.mapper;

import com.muc.bean.GoodsInfo;
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

public interface GoodsInfoMapper {
    @Delete({
        "delete from product",
        "where pro_Id = #{pro_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer pro_id);

    @Insert({
        "insert into product ( pro_Name, ",
        "goodsType, pro_Sell, ",
        "pro_Cost, pro_All, ",
        "pro_Left)",
        "values ( #{pro_name,jdbcType=VARCHAR}, ",
        "#{goodstype,jdbcType=INTEGER}, #{pro_sell,jdbcType=REAL}, ",
        "#{pro_cost,jdbcType=REAL}, #{pro_all,jdbcType=INTEGER}, ",
        "#{pro_left,jdbcType=INTEGER})"
    })
    int insert(GoodsInfo record);

    @InsertProvider(type=GoodsInfoSqlProvider.class, method="insertSelective")
    int insertSelective(GoodsInfo record);

    @Select({
        "select",
        "pro_Id, pro_Name, goodsType, pro_Sell, pro_Cost, pro_All, ",
        "pro_Left",
        "from product",
        "where pro_Id = #{pro_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="pro_Id", property="pro_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pro_Name", property="pro_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="goodsType", property="goodstype", jdbcType=JdbcType.INTEGER),
        @Result(column="pro_Sell", property="pro_sell", jdbcType=JdbcType.REAL),
        @Result(column="pro_Cost", property="pro_cost", jdbcType=JdbcType.REAL),
        @Result(column="pro_All", property="pro_all", jdbcType=JdbcType.INTEGER),
        @Result(column="pro_Left", property="pro_left", jdbcType=JdbcType.INTEGER)
    })
    GoodsInfo selectByPrimaryKey(Integer pro_id);

    @UpdateProvider(type=GoodsInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GoodsInfo record);

    @Update({
        "update product",
        "set pro_Name = #{pro_name,jdbcType=VARCHAR},",
          "goodsType = #{goodstype,jdbcType=INTEGER},",
          "pro_Sell = #{pro_sell,jdbcType=REAL},",
        "where pro_Id = #{pro_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GoodsInfo record);

    @Select({
            "select",
            "pro_Id, pro_Name, goodsType, pro_Sell, pro_Cost, pro_All, ",
            "pro_Left",
            "from product"
    })
    @Results({
            @Result(column="pro_Id", property="pro_id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="pro_Name", property="pro_name", jdbcType=JdbcType.VARCHAR),
            @Result(column="goodsType", property="goodstype", jdbcType=JdbcType.INTEGER),
            @Result(column="pro_Sell", property="pro_sell", jdbcType=JdbcType.REAL),
            @Result(column="pro_Cost", property="pro_cost", jdbcType=JdbcType.REAL),
            @Result(column="pro_All", property="pro_all", jdbcType=JdbcType.INTEGER),
            @Result(column="pro_Left", property="pro_left", jdbcType=JdbcType.INTEGER)
    })
    List<GoodsInfo> selectAll();

    @Update({
            "update product",
            "set pro_Cost = (pro_Cost*pro_All + ${number} * ${price})/(pro_All+ ${number}), ",
            "pro_All = pro_All+ ${number},",
            "pro_Left = pro_Left+ ${number}",
            "where pro_Id = ${id}"
    })
    int inputGoods(Integer id,Integer number,float price);

    @Select({
            "select",
            "pro_Left",
            "from product",
            "where pro_Id= #{pro_id,jdbcType=INTEGER}"
    })
   int selectLeftById(Integer pro_id);

    @Update({
            "update product",
            "set pro_Left = pro_Left - ${number}",
            "where pro_Id = ${id}"
    })
    int updateLeftById(Integer id,Integer number);

    @Select({
            "select",
            "pro_Name",
            "from product",
            "where pro_Id= #{pro_id,jdbcType=INTEGER}"
    })
    GoodsInfo selectNameById(Integer pro_id);
}
