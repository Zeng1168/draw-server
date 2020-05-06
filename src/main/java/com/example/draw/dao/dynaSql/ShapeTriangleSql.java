package com.example.draw.dao.dynaSql;

import com.example.draw.entity.ShapeTriangle;
import org.apache.ibatis.jdbc.SQL;


// Created on 2020-05-06 09:07:06

public class ShapeTriangleSql {

    // Auto Created by Zeng
    public String insertShapeTriangle(ShapeTriangle shapeTriangle){
        return new SQL(){
            {
                INSERT_INTO("shape_triangle");
                VALUES("user_id","#{userId}");
                VALUES("time","#{time}");
                VALUES("x","#{X}");
                VALUES("y","#{Y}");
                VALUES("color","#{color}");
                VALUES("stroke","#{stroke}");
                VALUES("x2","#{x2}");
                VALUES("y2","#{y2}");
                VALUES("x3","#{x3}");
                VALUES("y3","#{y3}");
                if(shapeTriangle.getName() != null){
                    VALUES("name","#{name}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String selectByMutiParamsShapeTriangle(ShapeTriangle shapeTriangle){
        return new SQL(){
            {
                SELECT("*");
                FROM("shape_triangle");
                if(shapeTriangle.getId() != null){
                    WHERE("id = #{id}");
                }
                if(shapeTriangle.getUserId() != null){
                    WHERE("user_id = #{userId}");
                }
                if(shapeTriangle.getName() != null){
                    WHERE("name = #{name}");
                }
                if(shapeTriangle.getTime() != null){
                    WHERE("time = #{time}");
                }
                if(shapeTriangle.getX() != null){
                    WHERE("x = #{X}");
                }
                if(shapeTriangle.getY() != null){
                    WHERE("y = #{Y}");
                }
                if(shapeTriangle.getColor() != null){
                    WHERE("color = #{color}");
                }
                if(shapeTriangle.getStroke() != null){
                    WHERE("stroke = #{stroke}");
                }
                if(shapeTriangle.getX2() != null){
                    WHERE("x2 = #{x2}");
                }
                if(shapeTriangle.getY2() != null){
                    WHERE("y2 = #{y2}");
                }
                if(shapeTriangle.getX3() != null){
                    WHERE("x3 = #{x3}");
                }
                if(shapeTriangle.getY3() != null){
                    WHERE("y3 = #{y3}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updatePartShapeTriangle(ShapeTriangle shapeTriangle){
        return new SQL(){
            {
                UPDATE("shape_triangle");
                if(shapeTriangle.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(shapeTriangle.getName() != null){
                    SET("name = #{name}");
                }
                if(shapeTriangle.getTime() != null){
                    SET("time = #{time}");
                }
                if(shapeTriangle.getX() != null){
                    SET("x = #{X}");
                }
                if(shapeTriangle.getY() != null){
                    SET("y = #{Y}");
                }
                if(shapeTriangle.getColor() != null){
                    SET("color = #{color}");
                }
                if(shapeTriangle.getStroke() != null){
                    SET("stroke = #{stroke}");
                }
                if(shapeTriangle.getX2() != null){
                    SET("x2 = #{x2}");
                }
                if(shapeTriangle.getY2() != null){
                    SET("y2 = #{y2}");
                }
                if(shapeTriangle.getX3() != null){
                    SET("x3 = #{x3}");
                }
                if(shapeTriangle.getY3() != null){
                    SET("y3 = #{y3}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updateALLShapeTriangle(ShapeTriangle shapeTriangle){
        return new SQL(){
            {
                UPDATE("shape_triangle");
                if(shapeTriangle.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(shapeTriangle.getName() != null){
                    SET("name = #{name}");
                }else {
                    SET("name = null");
                }
                if(shapeTriangle.getTime() != null){
                    SET("time = #{time}");
                }
                if(shapeTriangle.getX() != null){
                    SET("x = #{X}");
                }
                if(shapeTriangle.getY() != null){
                    SET("y = #{Y}");
                }
                if(shapeTriangle.getColor() != null){
                    SET("color = #{color}");
                }
                if(shapeTriangle.getStroke() != null){
                    SET("stroke = #{stroke}");
                }
                if(shapeTriangle.getX2() != null){
                    SET("x2 = #{x2}");
                }
                if(shapeTriangle.getY2() != null){
                    SET("y2 = #{y2}");
                }
                if(shapeTriangle.getX3() != null){
                    SET("x3 = #{x3}");
                }
                if(shapeTriangle.getY3() != null){
                    SET("y3 = #{y3}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

}
