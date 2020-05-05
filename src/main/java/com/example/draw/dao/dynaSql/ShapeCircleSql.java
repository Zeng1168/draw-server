package com.example.draw.dao.dynaSql;

import com.example.draw.entity.ShapeCircle;
import org.apache.ibatis.jdbc.SQL;


// Created on 2020-05-04 20:01:19

public class ShapeCircleSql {

    // Auto Created by Zeng
    public String insertShapeCircle(ShapeCircle shapeCircle){
        return new SQL(){
            {
                INSERT_INTO("shape_circle");
                VALUES("user_id","#{userId}");
                VALUES("time","#{time}");
                VALUES("x","#{X}");
                VALUES("y","#{Y}");
                VALUES("radius","#{radius}");
                VALUES("color","#{color}");
                VALUES("stroke","#{stroke}");
                if(shapeCircle.getName() != null){
                    VALUES("name","#{name}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String selectByMutiParamsShapeCircle(ShapeCircle shapeCircle){
        return new SQL(){
            {
                SELECT("*");
                FROM("shape_circle");
                if(shapeCircle.getId() != null){
                    WHERE("id = #{id}");
                }
                if(shapeCircle.getUserId() != null){
                    WHERE("user_id = #{userId}");
                }
                if(shapeCircle.getName() != null){
                    WHERE("name = #{name}");
                }
                if(shapeCircle.getTime() != null){
                    WHERE("time = #{time}");
                }
                if(shapeCircle.getX() != null){
                    WHERE("x = #{X}");
                }
                if(shapeCircle.getY() != null){
                    WHERE("y = #{Y}");
                }
                if(shapeCircle.getRadius() != null){
                    WHERE("radius = #{radius}");
                }
                if(shapeCircle.getColor() != null){
                    WHERE("color = #{color}");
                }
                if(shapeCircle.getStroke() != null){
                    WHERE("stroke = #{stroke}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updatePartShapeCircle(ShapeCircle shapeCircle){
        return new SQL(){
            {
                UPDATE("shape_circle");
                if(shapeCircle.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(shapeCircle.getName() != null){
                    SET("name = #{name}");
                }
                if(shapeCircle.getTime() != null){
                    SET("time = #{time}");
                }
                if(shapeCircle.getX() != null){
                    SET("x = #{X}");
                }
                if(shapeCircle.getY() != null){
                    SET("y = #{Y}");
                }
                if(shapeCircle.getRadius() != null){
                    SET("radius = #{radius}");
                }
                if(shapeCircle.getColor() != null){
                    SET("color = #{color}");
                }
                if(shapeCircle.getStroke() != null){
                    SET("stroke = #{stroke}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updateALLShapeCircle(ShapeCircle shapeCircle){
        return new SQL(){
            {
                UPDATE("shape_circle");
                if(shapeCircle.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(shapeCircle.getName() != null){
                    SET("name = #{name}");
                }else {
                    SET("name = null");
                }
                if(shapeCircle.getTime() != null){
                    SET("time = #{time}");
                }
                if(shapeCircle.getX() != null){
                    SET("x = #{X}");
                }
                if(shapeCircle.getY() != null){
                    SET("y = #{Y}");
                }
                if(shapeCircle.getRadius() != null){
                    SET("radius = #{radius}");
                }
                if(shapeCircle.getColor() != null){
                    SET("color = #{color}");
                }
                if(shapeCircle.getStroke() != null){
                    SET("stroke = #{stroke}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

}
