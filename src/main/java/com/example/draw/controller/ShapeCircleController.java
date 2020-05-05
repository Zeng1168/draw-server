package com.example.draw.controller;

import com.example.draw.entity.ShapeCircle;
import com.example.draw.service.ShapeCircleService;
import com.example.draw.utils.Result;
import com.example.draw.utils.UserUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//  Created on 2020-05-04 20:01:19

@Api(tags = "绘制圆形")
@CrossOrigin
@RestController
@RequestMapping("/shapeCircle/")
public class ShapeCircleController {

    @Autowired
    ShapeCircleService shapeCircleService;


    // Auto Created by Zeng
    @ApiOperation(value = "查询当前用户绘制的所有圆形",httpMethod = "GET",notes = "Auto Creat")
    @GetMapping("selectAll")
    public Result selectByUser(){
        Integer userId = UserUtils.getNowUserId();
        if(userId == null){
            return Result.error("Not required userId!", "");
        }else {
            return Result.ok(shapeCircleService.selectByUser(userId));
        }
    }

    // Auto Created by Zeng
    @ApiOperation(value = "insert",httpMethod = "POST",notes = "Auto Creat")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name",value = "图形名称"),
        @ApiImplicitParam(name = "x",value = "圆心坐标x",required = true),
        @ApiImplicitParam(name = "y",value = "圆心坐标y",required = true),
        @ApiImplicitParam(name = "radius",value = "半径",required = true),
        @ApiImplicitParam(name = "color",value = "颜色",required = true),
        @ApiImplicitParam(name = "stroke",value = "线条粗细",required = true),
    })
    @PostMapping("insert")
    public Result insert(ShapeCircle shapeCircle){
        Integer userId = UserUtils.getNowUserId();
        shapeCircle.setUserId(userId);
        int num = shapeCircleService.insert(shapeCircle);
        if(num == 1){
            return Result.ok("Successful!","");
        }else {
            return Result.error("Failure!","");
        }
    }



}
