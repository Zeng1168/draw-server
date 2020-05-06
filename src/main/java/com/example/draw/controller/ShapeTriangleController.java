package com.example.draw.controller;

import com.example.draw.entity.ShapeTriangle;
import com.example.draw.service.ShapeTriangleService;
import com.example.draw.utils.Result;
import com.example.draw.utils.UserUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//  Created on 2020-05-06 09:07:06

@Api(tags = "绘制三角形")
@CrossOrigin
@RestController
@RequestMapping("/shapeTriangle/")
public class ShapeTriangleController {

    @Autowired
    ShapeTriangleService shapeTriangleService;


    // Auto Created by Zeng
    @ApiOperation(value = "selectById",httpMethod = "GET",notes = "Auto Creat")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",value = "shapeTriangleId",required = true ,dataType="int")
    })
    @GetMapping("selectById")
    public Result selectById(Integer id){
        if(id == null){
            return Result.error("Not required id!");
        }else {
            return Result.ok(shapeTriangleService.selectById(id));
        }
    }

    // Auto Created by Zeng
    @ApiOperation(value = "insert",httpMethod = "POST",notes = "Auto Creat")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId",value = "用户id",required = true),
        @ApiImplicitParam(name = "name",value = "图形名称"),
        @ApiImplicitParam(name = "time",value = "绘制时间",required = true),
        @ApiImplicitParam(name = "X",value = "",required = true),
        @ApiImplicitParam(name = "Y",value = "",required = true),
        @ApiImplicitParam(name = "color",value = "颜色",required = true),
        @ApiImplicitParam(name = "stroke",value = "线条粗细",required = true),
        @ApiImplicitParam(name = "x2",value = "",required = true),
        @ApiImplicitParam(name = "y2",value = "",required = true),
        @ApiImplicitParam(name = "x3",value = "",required = true),
        @ApiImplicitParam(name = "y3",value = "",required = true),
    })
    @PostMapping("insert")
    public Result insert(ShapeTriangle shapeTriangle){
        int num = shapeTriangleService.insert(shapeTriangle);
        if(num == 1){
            return Result.ok("Successful!","");
        }else {
            return Result.error("Failure!","");
        }
    }



}
