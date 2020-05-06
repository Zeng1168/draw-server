package com.example.draw.entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


// Created on 2020-05-06 09:07:06

@ApiModel("绘制圆形")
public class ShapeRectagle {

    private Integer id;
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "图形名称")
    private String name;
    @ApiModelProperty(value = "绘制时间")
    private Date time;
    @ApiModelProperty(value = "圆心坐标x")
    private Integer X;
    @ApiModelProperty(value = "圆心坐标y")
    private Integer Y;
    @ApiModelProperty(value = "高度")
    private Integer height;
    @ApiModelProperty(value = "宽度")
    private Integer width;
    @ApiModelProperty(value = "颜色")
    private Integer color;
    @ApiModelProperty(value = "线条粗细")
    private Integer stroke;

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
        sb.append("\"X\":")
                .append(X);
        sb.append("\"Y\":")
                .append(Y);
        sb.append("\"height\":")
                .append(height);
        sb.append("\"width\":")
                .append(width);
        sb.append("\"color\":")
                .append(color);
        sb.append("\"stroke\":")
                .append(stroke);
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

    public Integer getX() {
        return X;
    }

    public void setX(Integer X) {
        this.X = X;
    }

    public Integer getY() {
        return Y;
    }

    public void setY(Integer Y) {
        this.Y = Y;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getStroke() {
        return stroke;
    }

    public void setStroke(Integer stroke) {
        this.stroke = stroke;
    }



}
