package com.example.draw.dao.dynaSql;

import com.example.draw.entity.ShapeRectagle;
import org.apache.ibatis.jdbc.SQL;


// Created on 2020-05-06 09:07:06

public class ShapeRectagleSql {

    // Auto Created by Zeng
    public String insertShapeRectagle(ShapeRectagle shapeRectagle){
        return new SQL(){
            {
                INSERT_INTO("shape_rectagle");
                VALUES("user_id","#{userId}");
                VALUES("time","#{time}");
                VALUES("x","#{X}");
                VALUES("y","#{Y}");
                VALUES("height","#{height}");
                VALUES("width","#{width}");
                VALUES("color","#{color}");
                VALUES("stroke","#{stroke}");
                if(shapeRectagle.getName() != null){
                    VALUES("name","#{name}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String selectByMutiParamsShapeRectagle(ShapeRectagle shapeRectagle){
        return new SQL(){
            {
                SELECT("*");
                FROM("shape_rectagle");
                if(shapeRectagle.getId() != null){
                    WHERE("id = #{id}");
                }
                if(shapeRectagle.getUserId() != null){
                    WHERE("user_id = #{userId}");
                }
                if(shapeRectagle.getName() != null){
                    WHERE("name = #{name}");
                }
                if(shapeRectagle.getTime() != null){
                    WHERE("time = #{time}");
                }
                if(shapeRectagle.getX() != null){
                    WHERE("x = #{X}");
                }
                if(shapeRectagle.getY() != null){
                    WHERE("y = #{Y}");
                }
                if(shapeRectagle.getHeight() != null){
                    WHERE("height = #{height}");
                }
                if(shapeRectagle.getWidth() != null){
                    WHERE("width = #{width}");
                }
                if(shapeRectagle.getColor() != null){
                    WHERE("color = #{color}");
                }
                if(shapeRectagle.getStroke() != null){
                    WHERE("stroke = #{stroke}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updatePartShapeRectagle(ShapeRectagle shapeRectagle){
        return new SQL(){
            {
                UPDATE("shape_rectagle");
                if(shapeRectagle.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(shapeRectagle.getName() != null){
                    SET("name = #{name}");
                }
                if(shapeRectagle.getTime() != null){
                    SET("time = #{time}");
                }
                if(shapeRectagle.getX() != null){
                    SET("x = #{X}");
                }
                if(shapeRectagle.getY() != null){
                    SET("y = #{Y}");
                }
                if(shapeRectagle.getHeight() != null){
                    SET("height = #{height}");
                }
                if(shapeRectagle.getWidth() != null){
                    SET("width = #{width}");
                }
                if(shapeRectagle.getColor() != null){
                    SET("color = #{color}");
                }
                if(shapeRectagle.getStroke() != null){
                    SET("stroke = #{stroke}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updateALLShapeRectagle(ShapeRectagle shapeRectagle){
        return new SQL(){
            {
                UPDATE("shape_rectagle");
                if(shapeRectagle.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(shapeRectagle.getName() != null){
                    SET("name = #{name}");
                }else {
                    SET("name = null");
                }
                if(shapeRectagle.getTime() != null){
                    SET("time = #{time}");
                }
                if(shapeRectagle.getX() != null){
                    SET("x = #{X}");
                }
                if(shapeRectagle.getY() != null){
                    SET("y = #{Y}");
                }
                if(shapeRectagle.getHeight() != null){
                    SET("height = #{height}");
                }
                if(shapeRectagle.getWidth() != null){
                    SET("width = #{width}");
                }
                if(shapeRectagle.getColor() != null){
                    SET("color = #{color}");
                }
                if(shapeRectagle.getStroke() != null){
                    SET("stroke = #{stroke}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

}
