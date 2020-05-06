package com.example.draw.controller;

import com.example.draw.entity.ShapeBox;
import com.example.draw.service.ShapeBoxService;
import com.example.draw.utils.Result;
import com.example.draw.utils.UserUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//  Created on 2020-05-06 09:07:06

@Api(tags = "绘制正方体")
@CrossOrigin
@RestController
@RequestMapping("/shapeBox/")
public class ShapeBoxController {

    @Autowired
    ShapeBoxService shapeBoxService;


    // Auto Created by Zeng
    @ApiOperation(value = "selectById",httpMethod = "GET",notes = "Auto Creat")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",value = "shapeBoxId",required = true ,dataType="int")
    })
    @GetMapping("selectById")
    public Result selectById(Integer id){
        if(id == null){
            return Result.error("Not required id!");
        }else {
            return Result.ok(shapeBoxService.selectById(id));
        }
    }

    // Auto Created by Zeng
    @ApiOperation(value = "insert",httpMethod = "POST",notes = "Auto Creat")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId",value = "用户id",required = true),
        @ApiImplicitParam(name = "name",value = "图形名称"),
        @ApiImplicitParam(name = "time",value = "绘制时间",required = true),
        @ApiImplicitParam(name = "X",value = "圆心坐标x",required = true),
        @ApiImplicitParam(name = "Y",value = "圆心坐标y",required = true),
        @ApiImplicitParam(name = "width",value = "宽度",required = true),
        @ApiImplicitParam(name = "color",value = "颜色",required = true),
        @ApiImplicitParam(name = "stroke",value = "线条粗细",required = true),
        @ApiImplicitParam(name = "height",value = "高度",required = true),
    })
    @PostMapping("insert")
    public Result insert(ShapeBox shapeBox){
        int num = shapeBoxService.insert(shapeBox);
        if(num == 1){
            return Result.ok("Successful!","");
        }else {
            return Result.error("Failure!","");
        }
    }



}
