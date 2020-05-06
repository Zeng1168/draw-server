package com.example.draw.entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


// Created on 2020-05-06 09:07:06

@ApiModel("绘制圆形")
public class ShapeSphere {

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
    @ApiModelProperty(value = "半径")
    private Double radius;
    private Double volume;
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
        sb.append("\"radius\":")
                .append(radius);
        sb.append("\"volume\":")
                .append(volume);
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

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
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
