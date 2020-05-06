package com.example.draw.dao;

import com.example.draw.entity.ShapeSphere;
import com.example.draw.dao.dynaSql.ShapeSphereSql;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


//  Created on 2020-05-06 09:07:06

@Mapper
@Repository
public interface ShapeSphereDao {


    // Auto Created by Zeng
    @Select("SELECT * FROM shape_sphere WHERE id=#{id}")
    ShapeSphere selectById(Integer id);

    // Auto Created by Zeng
    @InsertProvider(type = ShapeSphereSql.class,method = "insertShapeSphere")
    int insertShapeSphere(ShapeSphere shapeSphere);



}
