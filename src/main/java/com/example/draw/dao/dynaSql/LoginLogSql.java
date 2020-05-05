package com.example.draw.dao.dynaSql;

import com.example.draw.entity.LoginLog;
import org.apache.ibatis.jdbc.SQL;


// Created on 2020-05-04 18:09:07

public class LoginLogSql {

    // Auto Created by Zeng
    public String insertLoginLog(LoginLog loginLog){
        return new SQL(){
            {
                INSERT_INTO("login_log");
                VALUES("time","#{time}");
                if(loginLog.getUserId() != null){
                    VALUES("user_id","#{userId}");
                }
                if(loginLog.getType() != null){
                    VALUES("type","#{type}");
                }
                if(loginLog.getIpAddress() != null){
                    VALUES("ip_address","#{ipAddress}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String selectByMutiParamsLoginLog(LoginLog loginLog){
        return new SQL(){
            {
                SELECT("*");
                FROM("login_log");
                if(loginLog.getTime() != null){
                    WHERE("time = #{time}");
                }
                if(loginLog.getUserId() != null){
                    WHERE("user_id = #{userId}");
                }
                if(loginLog.getType() != null){
                    WHERE("type = #{type}");
                }
                if(loginLog.getIpAddress() != null){
                    WHERE("ip_address = #{ipAddress}");
                }
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updatePartLoginLog(LoginLog loginLog){
        return new SQL(){
            {
                UPDATE("login_log");
                if(loginLog.getTime() != null){
                    SET("time = #{time}");
                }
                if(loginLog.getUserId() != null){
                    SET("user_id = #{userId}");
                }
                if(loginLog.getType() != null){
                    SET("type = #{type}");
                }
                if(loginLog.getIpAddress() != null){
                    SET("ip_address = #{ipAddress}");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

    // Auto Created by Zeng
    public String updateALLLoginLog(LoginLog loginLog){
        return new SQL(){
            {
                UPDATE("login_log");
                if(loginLog.getTime() != null){
                    SET("time = #{time}");
                }
                if(loginLog.getUserId() != null){
                    SET("user_id = #{userId}");
                }else {
                    SET("user_id = null");
                }
                if(loginLog.getType() != null){
                    SET("type = #{type}");
                }else {
                    SET("type = null");
                }
                if(loginLog.getIpAddress() != null){
                    SET("ip_address = #{ipAddress}");
                }else {
                    SET("ip_address = null");
                }
                WHERE("id = #{id}");
             }
        }.toString();
    }

}
