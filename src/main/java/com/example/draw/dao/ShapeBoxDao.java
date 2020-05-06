package com.example.draw.dao;

import com.example.draw.entity.ShapeBox;
import com.example.draw.dao.dynaSql.ShapeBoxSql;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


//  Created on 2020-05-06 09:07:06

@Mapper
@Repository
public interface ShapeBoxDao {


    // Auto Created by Zeng
    @Select("SELECT * FROM shape_box WHERE id=#{id}")
    ShapeBox selectById(Integer id);

    // Auto Created by Zeng
    @InsertProvider(type = ShapeBoxSql.class,method = "insertShapeBox")
    int insertShapeBox(ShapeBox shapeBox);



}
