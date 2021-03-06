package com.example.draw.utils;

import io.swagger.annotations.ApiModelProperty;

public class Result {
    @ApiModelProperty(value = "状态码")
    private Integer status;
    @ApiModelProperty(value = "状态信息")
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private Object data;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public Result() {}

    public Result(ResultCode resultEnum) {
        this.setStatus(resultEnum.getCode());
        this.setMsg(resultEnum.getMsg());
    }

    public Result(Integer status, String msg, Object data) {
        this.setStatus(status);
        this.setMsg(msg);
        this.setData(data);
    }


    public static Result ok(Object data) {
        return ok(ResultCode.SUCCESS.getMsg(), data);
    }

    public static Result ok(String msg, Object data) {
        return new Result(ResultCode.SUCCESS.getCode(), msg, data);
    }

    public static Result error(Object data) {
        return error(ResultCode.ERROR.getMsg(), data);
    }

    public static Result error(String msg, Object data) {
        return new Result(ResultCode.ERROR.getCode(), msg, data);
    }




}
