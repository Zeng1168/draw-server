package com.example.draw.dao.dynaSql;

import com.example.draw.entity.DrawPlanform;
import org.apache.ibatis.jdbc.SQL;


// Created on 2020-05-04 19:32:05

public class DrawPlanformSql {

    // Auto Created by Zeng
    public String insertDrawPlanform(DrawPlanform drawPlanform){
        return new SQL(){
            {
                INSERT_INTO("draw_planform");
                VALUES("id","#{id}");
                VALUES("user_id","#{userId}");
                VALUES("time","#{time}");
                VALUES("image","#{image}");
                VALUES("is_useful","#{isUseful}");
                if(drawPlanform.getName() != null){
                    VALUES("name","#{name}");
                }
                if(drawPlanform.getInvitingCode() != null){
                    VALUES("inviting_code","#{invitingCode}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String selectByMutiParamsDrawPlanform(DrawPlanform drawPlanform){
        return new SQL(){
            {
                SELECT("*");
                FROM("draw_planform");
                if(drawPlanform.getId() != null){
                    WHERE("id = #{id}");
                }
                if(drawPlanform.getUserId() != null){
                    WHERE("user_id = #{userId}");
                }
                if(drawPlanform.getName() != null){
                    WHERE("name = #{name}");
                }
                if(drawPlanform.getTime() != null){
                    WHERE("time = #{time}");
                }
                if(drawPlanform.getImage() != null){
                    WHERE("image = #{image}");
                }
                if(drawPlanform.getIsUseful() != null){
                    WHERE("is_useful = #{isUseful}");
                }
                if(drawPlanform.getInvitingCode() != null){
                    WHERE("inviting_code = #{invitingCode}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updatePartDrawPlanform(DrawPlanform drawPlanform){
        return new SQL(){
            {
                UPDATE("draw_planform");
                if(drawPlanform.getId() != null){
                    SET("id = #{id}");
                }
                if(drawPlanform.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(drawPlanform.getName() != null){
                    SET("name = #{name}");
                }
                if(drawPlanform.getTime() != null){
                    SET("time = #{time}");
                }
                if(drawPlanform.getImage() != null){
                    SET("image = #{image}");
                }
                if(drawPlanform.getIsUseful() != null){
                    SET("is_useful = #{isUseful}");
                }
                if(drawPlanform.getInvitingCode() != null){
                    SET("inviting_code = #{invitingCode}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updateALLDrawPlanform(DrawPlanform drawPlanform){
        return new SQL(){
            {
                UPDATE("draw_planform");
                if(drawPlanform.getId() != null){
                    SET("id = #{id}");
                }
                if(drawPlanform.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(drawPlanform.getName() != null){
                    SET("name = #{name}");
                }else {
                    SET("name = null");
                }
                if(drawPlanform.getTime() != null){
                    SET("time = #{time}");
                }
                if(drawPlanform.getImage() != null){
                    SET("image = #{image}");
                }
                if(drawPlanform.getIsUseful() != null){
                    SET("is_useful = #{isUseful}");
                }
                if(drawPlanform.getInvitingCode() != null){
                    SET("inviting_code = #{invitingCode}");
                }else {
                    SET("inviting_code = null");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

}
