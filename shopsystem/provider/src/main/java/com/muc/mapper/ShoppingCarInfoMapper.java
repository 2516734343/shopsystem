package com.muc.mapper;

import com.muc.bean.GoodsType;
import com.muc.bean.ShoppingCarInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ShoppingCarInfoMapper {
    @Insert({
        "insert into order_cart (user_id, goodid, ",
        "goodsNumber, toCarDate)",
        "values (#{user_id,jdbcType=INTEGER}, #{goodid,jdbcType=INTEGER}, ",
        "#{goodsnumber,jdbcType=INTEGER}, curdate() )"
    })
    int insert(ShoppingCarInfo record);

    @InsertProvider(type=ShoppingCarInfoSqlProvider.class, method="insertSelective")
    int insertSelective(ShoppingCarInfo record);

    @Delete({
            "delete from order_cart",
            "where goodid=#{goodid,jdbcType=INTEGER} and",
            "user_id=#{user_id,jdbcType=INTEGER}"

    })
    int DeleteOneGood(ShoppingCarInfo record);

    @Delete({
            "delete from order_cart",
            "where user_id=#{user_id,jdbcType=INTEGER}"
    })
    int DeleteAllGoodsByUser(Integer user_id);

    @Select({
            "select",
            "user_id, goodid,goodsNumber,DATE_FORMAT(toCarDate,'%Y-%d-%m')",
            "from order_cart",
            "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    List<ShoppingCarInfo> selectByUser(Integer user_id);

    @Update({
            "update order_cart",
            "set goodsNumber=#{goodsnumber,jdbcType=INTEGER}",
            "where goodid=#{goodid,jdbcType=INTEGER} and",
            "user_id=#{user_id,jdbcType=INTEGER}"
    })
    int updateGoodsNumber(ShoppingCarInfo record);

    //根据商品id找出商品数量
    @Select({
            "select",
            "goodid,goodsNumber",
            "from order_cart",
            "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    List<ShoppingCarInfo> fromIdFindNumber(Integer user_id);

    @Select({
            "select",
            "user_id, goodid,goodsNumber,toCarDate",
            "from order_cart"
    })
    List<ShoppingCarInfo> selectAll();
}
