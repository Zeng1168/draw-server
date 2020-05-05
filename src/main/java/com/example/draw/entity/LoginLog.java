package com.example.draw.entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


// Created on 2020-05-04 18:09:07

@ApiModel("LoginLog")
public class LoginLog {

    @ApiModelProperty(value = "时间")
    private Date time;
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "登录类型 1密码登录 2短信登录")
    private Integer type;
    @ApiModelProperty(value = "ip地址")
    private String ipAddress;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"time\":")
                .append(time);
        sb.append("\"userId\":")
                .append(userId);
        sb.append("\"type\":")
                .append(type);
        sb.append("\"ipAddress\":")
                .append(ipAddress);
        return sb.toString();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }



}
