package com.example.draw.utils;

public class StatusCodeUtil {

    public static String getUserStatusByCode(int status){
        String str = "未知状态！";

        switch (status){
            case 0 :str = "用户禁用！"; break;
            case 1 :str = "用户状态正常！"; break;
            case -1 :str = "用户已永久封号！"; break;
        }

        return str;
    }
}
