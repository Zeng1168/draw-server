package com.example.draw.entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


// Created on 2020-05-06 09:07:06

@ApiModel("绘制圆形")
public class ShapeTriangle {

    private Integer id;
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "图形名称")
    private String name;
    @ApiModelProperty(value = "绘制时间")
    private Date time;
    private Integer X;
    private Integer Y;
    @ApiModelProperty(value = "颜色")
    private Integer color;
    @ApiModelProperty(value = "线条粗细")
    private Integer stroke;
    private Integer x2;
    private Integer y2;
    private Integer x3;
    private Integer y3;

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
        sb.append("\"color\":")
                .append(color);
        sb.append("\"stroke\":")
                .append(stroke);
        sb.append("\"x2\":")
                .append(x2);
        sb.append("\"y2\":")
                .append(y2);
        sb.append("\"x3\":")
                .append(x3);
        sb.append("\"y3\":")
                .append(y3);
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

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    public Integer getX3() {
        return x3;
    }

    public void setX3(Integer x3) {
        this.x3 = x3;
    }

    public Integer getY3() {
        return y3;
    }

    public void setY3(Integer y3) {
        this.y3 = y3;
    }



}
