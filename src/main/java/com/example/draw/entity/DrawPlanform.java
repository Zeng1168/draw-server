package com.example.draw.entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


// Created on 2020-05-04 19:32:05

@ApiModel("平面绘制图像")
public class DrawPlanform {

    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "绘制图像名称")
    private String name;
    @ApiModelProperty(value = "绘制时间")
    private Date time;
    @ApiModelProperty(value = "绘制图形Base64编码")
    private String image;
    @ApiModelProperty(value = "状态 1正常 -1删除")
    private Integer isUseful;
    @ApiModelProperty(value = "邀请码(用于发起多人协作绘图)")
    private Integer invitingCode;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append("\"userId\":")
                .append(userId);
        sb.append("\"name\":")
                .append(name);
        sb.append("\"time\":")
                .append(time);
        sb.append("\"image\":")
                .append(image);
        sb.append("\"isUseful\":")
                .append(isUseful);
        sb.append("\"invitingCode\":")
                .append(invitingCode);
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIsUseful() {
        return isUseful;
    }

    public void setIsUseful(Integer isUseful) {
        this.isUseful = isUseful;
    }

    public Integer getInvitingCode() {
        return invitingCode;
    }

    public void setInvitingCode(Integer invitingCode) {
        this.invitingCode = invitingCode;
    }



}
