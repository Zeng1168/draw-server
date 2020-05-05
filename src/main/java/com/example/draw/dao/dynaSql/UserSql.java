package com.example.draw.dao.dynaSql;

import com.example.draw.entity.User;
import org.apache.ibatis.jdbc.SQL;


// Created on 2020-05-04 19:17:12

public class UserSql {

    // Auto Created by Zeng
    public String insertUser(User user){
        return new SQL(){
            {
                INSERT_INTO("user");
                VALUES("username","#{username}");
                VALUES("password","#{password}");
                VALUES("sign_time","#{signTime}");
                VALUES("is_useful","#{isUseful}");
                if(user.getPhone() != null){
                    VALUES("phone","#{phone}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String selectByMutiParamsUser(User user){
        return new SQL(){
            {
                SELECT("*");
                FROM("user");
                if(user.getId() != null){
                    WHERE("id = #{id}");
                }
                if(user.getUsername() != null){
                    WHERE("username = #{username}");
                }
                if(user.getPhone() != null){
                    WHERE("phone = #{phone}");
                }
                if(user.getPassword() != null){
                    WHERE("password = #{password}");
                }
                if(user.getSignTime() != null){
                    WHERE("sign_time = #{signTime}");
                }
                if(user.getIsUseful() != null){
                    WHERE("is_useful = #{isUseful}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updatePartUser(User user){
        return new SQL(){
            {
                UPDATE("user");
                if(user.getUsername() != null){
                    SET("username = #{username}");
                }
                if(user.getPhone() != null){
                    SET("phone = #{phone}");
                }
                if(user.getPassword() != null){
                    SET("password = #{password}");
                }
                if(user.getSignTime() != null){
                    SET("sign_time = #{signTime}");
                }
                if(user.getIsUseful() != null){
                    SET("is_useful = #{isUseful}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updateALLUser(User user){
        return new SQL(){
            {
                UPDATE("user");
                if(user.getUsername() != null){
                    SET("username = #{username}");
                }
                if(user.getPhone() != null){
                    SET("phone = #{phone}");
                }else {
                    SET("phone = null");
                }
                if(user.getPassword() != null){
                    SET("password = #{password}");
                }
                if(user.getSignTime() != null){
                    SET("sign_time = #{signTime}");
                }
                if(user.getIsUseful() != null){
                    SET("is_useful = #{isUseful}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

}
