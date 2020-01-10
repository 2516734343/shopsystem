package com.muc.mapper;

import com.muc.bean.GoodsType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface GoodsTypeMapper {
    @Delete({
        "delete from goodstype",
        "where typeId = #{typeid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer typeid);

    @Insert({
        "insert into goodstype (typeName)",
        "values ( #{typename,jdbcType=VARCHAR})"
    })
    int insert(GoodsType record);

    @InsertProvider(type=GoodsTypeSqlProvider.class, method="insertSelective")
    int insertSelective(GoodsType record);

    @Select({
        "select",
        "typeId, typeName",
        "from goodstype",
        "where typeId = #{typeid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="typeId", property="typeid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="typeName", property="typename", jdbcType=JdbcType.VARCHAR)
    })
    GoodsType selectByPrimaryKey(Integer typeid);

    @UpdateProvider(type=GoodsTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GoodsType record);

    @Update({
        "update goodstype",
        "set typeName = #{typename,jdbcType=VARCHAR}",
        "where typeId = #{typeid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GoodsType record);


    @Select({
            "select",
            "typeId, typeName",
            "from goodstype"

    })
    @Results({
            @Result(column="typeId", property="typeid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="typeName", property="typename", jdbcType=JdbcType.VARCHAR)
    })
    List<GoodsType> selectAll();
}