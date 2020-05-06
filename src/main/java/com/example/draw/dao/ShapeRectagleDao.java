package com.example.draw.dao;

import com.example.draw.entity.ShapeRectagle;
import com.example.draw.dao.dynaSql.ShapeRectagleSql;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


//  Created on 2020-05-06 09:07:06

@Mapper
@Repository
public interface ShapeRectagleDao {


    // Auto Created by Zeng
    @Select("SELECT * FROM shape_rectagle WHERE id=#{id}")
    ShapeRectagle selectById(Integer id);

    // Auto Created by Zeng
    @InsertProvider(type = ShapeRectagleSql.class,method = "insertShapeRectagle")
    int insertShapeRectagle(ShapeRectagle shapeRectagle);



}
