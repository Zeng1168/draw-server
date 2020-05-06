package com.example.draw.dao.dynaSql;

import com.example.draw.entity.ShapeSphere;
import org.apache.ibatis.jdbc.SQL;


// Created on 2020-05-06 09:07:06

public class ShapeSphereSql {

    // Auto Created by Zeng
    public String insertShapeSphere(ShapeSphere shapeSphere){
        return new SQL(){
            {
                INSERT_INTO("shape_sphere");
                VALUES("user_id","#{userId}");
                VALUES("time","#{time}");
                VALUES("x","#{X}");
                VALUES("y","#{Y}");
                VALUES("radius","#{radius}");
                VALUES("color","#{color}");
                VALUES("stroke","#{stroke}");
                if(shapeSphere.getName() != null){
                    VALUES("name","#{name}");
                }
                if(shapeSphere.getVolume() != null){
                    VALUES("volume","#{volume}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String selectByMutiParamsShapeSphere(ShapeSphere shapeSphere){
        return new SQL(){
            {
                SELECT("*");
                FROM("shape_sphere");
                if(shapeSphere.getId() != null){
                    WHERE("id = #{id}");
                }
                if(shapeSphere.getUserId() != null){
                    WHERE("user_id = #{userId}");
                }
                if(shapeSphere.getName() != null){
                    WHERE("name = #{name}");
                }
                if(shapeSphere.getTime() != null){
                    WHERE("time = #{time}");
                }
                if(shapeSphere.getX() != null){
                    WHERE("x = #{X}");
                }
                if(shapeSphere.getY() != null){
                    WHERE("y = #{Y}");
                }
                if(shapeSphere.getRadius() != null){
                    WHERE("radius = #{radius}");
                }
                if(shapeSphere.getVolume() != null){
                    WHERE("volume = #{volume}");
                }
                if(shapeSphere.getColor() != null){
                    WHERE("color = #{color}");
                }
                if(shapeSphere.getStroke() != null){
                    WHERE("stroke = #{stroke}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updatePartShapeSphere(ShapeSphere shapeSphere){
        return new SQL(){
            {
                UPDATE("shape_sphere");
                if(shapeSphere.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(shapeSphere.getName() != null){
                    SET("name = #{name}");
                }
                if(shapeSphere.getTime() != null){
                    SET("time = #{time}");
                }
                if(shapeSphere.getX() != null){
                    SET("x = #{X}");
                }
                if(shapeSphere.getY() != null){
                    SET("y = #{Y}");
                }
                if(shapeSphere.getRadius() != null){
                    SET("radius = #{radius}");
                }
                if(shapeSphere.getVolume() != null){
                    SET("volume = #{volume}");
                }
                if(shapeSphere.getColor() != null){
                    SET("color = #{color}");
                }
                if(shapeSphere.getStroke() != null){
                    SET("stroke = #{stroke}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updateALLShapeSphere(ShapeSphere shapeSphere){
        return new SQL(){
            {
                UPDATE("shape_sphere");
                if(shapeSphere.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(shapeSphere.getName() != null){
                    SET("name = #{name}");
                }else {
                    SET("name = null");
                }
                if(shapeSphere.getTime() != null){
                    SET("time = #{time}");
                }
                if(shapeSphere.getX() != null){
                    SET("x = #{X}");
                }
                if(shapeSphere.getY() != null){
                    SET("y = #{Y}");
                }
                if(shapeSphere.getRadius() != null){
                    SET("radius = #{radius}");
                }
                if(shapeSphere.getVolume() != null){
                    SET("volume = #{volume}");
                }else {
                    SET("volume = null");
                }
                if(shapeSphere.getColor() != null){
                    SET("color = #{color}");
                }
                if(shapeSphere.getStroke() != null){
                    SET("stroke = #{stroke}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

}
