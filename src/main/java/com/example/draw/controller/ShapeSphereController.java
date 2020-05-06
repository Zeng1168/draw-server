package com.example.draw.controller;

import com.example.draw.entity.ShapeSphere;
import com.example.draw.service.ShapeSphereService;
import com.example.draw.utils.Result;
import com.example.draw.utils.UserUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//  Created on 2020-05-06 09:07:06

@Api(tags = "绘制球体")
@CrossOrigin
@RestController
@RequestMapping("/shapeSphere/")
public class ShapeSphereController {

    @Autowired
    ShapeSphereService shapeSphereService;


    // Auto Created by Zeng
    @ApiOperation(value = "selectById",httpMethod = "GET",notes = "Auto Creat")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",value = "shapeSphereId",required = true ,dataType="int")
    })
    @GetMapping("selectById")
    public Result selectById(Integer id){
        if(id == null){
            return Result.error("Not required id!");
        }else {
            return Result.ok(shapeSphereService.selectById(id));
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
        @ApiImplicitParam(name = "radius",value = "半径",required = true),
        @ApiImplicitParam(name = "volume",value = ""),
        @ApiImplicitParam(name = "color",value = "颜色",required = true),
        @ApiImplicitParam(name = "stroke",value = "线条粗细",required = true),
    })
    @PostMapping("insert")
    public Result insert(ShapeSphere shapeSphere){
        int num = shapeSphereService.insert(shapeSphere);
        if(num == 1){
            return Result.ok("Successful!","");
        }else {
            return Result.error("Failure!","");
        }
    }



}
