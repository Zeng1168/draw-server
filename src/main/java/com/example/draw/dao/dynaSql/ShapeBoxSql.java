package com.example.draw.dao.dynaSql;

import com.example.draw.entity.ShapeBox;
import org.apache.ibatis.jdbc.SQL;


// Created on 2020-05-06 09:07:06

public class ShapeBoxSql {

    // Auto Created by Zeng
    public String insertShapeBox(ShapeBox shapeBox){
        return new SQL(){
            {
                INSERT_INTO("shape_box");
                VALUES("user_id","#{userId}");
                VALUES("time","#{time}");
                VALUES("x","#{X}");
                VALUES("y","#{Y}");
                VALUES("width","#{width}");
                VALUES("color","#{color}");
                VALUES("stroke","#{stroke}");
                VALUES("height","#{height}");
                if(shapeBox.getName() != null){
                    VALUES("name","#{name}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String selectByMutiParamsShapeBox(ShapeBox shapeBox){
        return new SQL(){
            {
                SELECT("*");
                FROM("shape_box");
                if(shapeBox.getId() != null){
                    WHERE("id = #{id}");
                }
                if(shapeBox.getUserId() != null){
                    WHERE("user_id = #{userId}");
                }
                if(shapeBox.getName() != null){
                    WHERE("name = #{name}");
                }
                if(shapeBox.getTime() != null){
                    WHERE("time = #{time}");
                }
                if(shapeBox.getX() != null){
                    WHERE("x = #{X}");
                }
                if(shapeBox.getY() != null){
                    WHERE("y = #{Y}");
                }
                if(shapeBox.getWidth() != null){
                    WHERE("width = #{width}");
                }
                if(shapeBox.getColor() != null){
                    WHERE("color = #{color}");
                }
                if(shapeBox.getStroke() != null){
                    WHERE("stroke = #{stroke}");
                }
                if(shapeBox.getHeight() != null){
                    WHERE("height = #{height}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updatePartShapeBox(ShapeBox shapeBox){
        return new SQL(){
            {
                UPDATE("shape_box");
                if(shapeBox.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(shapeBox.getName() != null){
                    SET("name = #{name}");
                }
                if(shapeBox.getTime() != null){
                    SET("time = #{time}");
                }
                if(shapeBox.getX() != null){
                    SET("x = #{X}");
                }
                if(shapeBox.getY() != null){
                    SET("y = #{Y}");
                }
                if(shapeBox.getWidth() != null){
                    SET("width = #{width}");
                }
                if(shapeBox.getColor() != null){
                    SET("color = #{color}");
                }
                if(shapeBox.getStroke() != null){
                    SET("stroke = #{stroke}");
                }
                if(shapeBox.getHeight() != null){
                    SET("height = #{height}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updateALLShapeBox(ShapeBox shapeBox){
        return new SQL(){
            {
                UPDATE("shape_box");
                if(shapeBox.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(shapeBox.getName() != null){
                    SET("name = #{name}");
                }else {
                    SET("name = null");
                }
                if(shapeBox.getTime() != null){
                    SET("time = #{time}");
                }
                if(shapeBox.getX() != null){
                    SET("x = #{X}");
                }
                if(shapeBox.getY() != null){
                    SET("y = #{Y}");
                }
                if(shapeBox.getWidth() != null){
                    SET("width = #{width}");
                }
                if(shapeBox.getColor() != null){
                    SET("color = #{color}");
                }
                if(shapeBox.getStroke() != null){
                    SET("stroke = #{stroke}");
                }
                if(shapeBox.getHeight() != null){
                    SET("height = #{height}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

}
