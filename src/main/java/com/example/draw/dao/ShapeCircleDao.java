package com.example.draw.dao;

import com.example.draw.entity.ShapeCircle;
import com.example.draw.dao.dynaSql.ShapeCircleSql;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


//  Created on 2020-05-04 20:01:19

@Mapper
@Repository
public interface ShapeCircleDao {


    // Auto Created by Zeng
    @Select("SELECT * FROM shape_circle WHERE id=#{id}")
    ShapeCircle selectById(Integer id);

    // Auto Created by Zeng
    @InsertProvider(type = ShapeCircleSql.class,method = "insertShapeCircle")
    int insertShapeCircle(ShapeCircle shapeCircle);


    @Select("SELECT * FROM shape_circle WHERE user_id=#{userId}")
    List<ShapeCircle> selectByUser(Integer userId);


}
