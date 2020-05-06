package com.example.draw.dao;

import com.example.draw.entity.ShapeTriangle;
import com.example.draw.dao.dynaSql.ShapeTriangleSql;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


//  Created on 2020-05-06 09:07:06

@Mapper
@Repository
public interface ShapeTriangleDao {


    // Auto Created by Zeng
    @Select("SELECT * FROM shape_triangle WHERE id=#{id}")
    ShapeTriangle selectById(Integer id);

    // Auto Created by Zeng
    @InsertProvider(type = ShapeTriangleSql.class,method = "insertShapeTriangle")
    int insertShapeTriangle(ShapeTriangle shapeTriangle);



}
