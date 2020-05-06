package com.example.draw.controller;

import com.example.draw.service.DrawPlanformService;
import com.example.draw.utils.Result;
import com.example.draw.utils.UserUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



//  Created on 2020-05-04 19:11:19

@Api(tags = "平面绘制图像")
@CrossOrigin
@RestController
@RequestMapping("/drawPlanform/")
public class DrawPlanformController {

    @Autowired
    DrawPlanformService drawPlanformService;


    // Auto Created by Zeng
    @ApiOperation(value = "查询当前用户绘制的所有平面图",httpMethod = "GET",notes = "Auto Creat")
    @GetMapping("selectAll")
    public Result selectAll(){
        Integer userId = UserUtils.getNowUserId();
        if(userId == null){
            return Result.error("Not required id!");
        }else {
            return Result.ok(drawPlanformService.selectByUser(userId));
        }
    }

    // Auto Created by Zeng
    @ApiOperation(value = "插入图像",httpMethod = "POST",notes = "Auto Creat")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name",value = "绘制图像名称"),
        @ApiImplicitParam(name = "image",value = "绘制图形Base64编码"),
    })
    @PostMapping("insert")
    public Result insert(String name, String image){
        Integer userId = UserUtils.getNowUserId();
        if(userId == null){
            return Result.error("未获取到用户id！");
        }else if(image == null || image.equals("")){
            return Result.error("未获取到图像！");
        }

        int num = drawPlanformService.insert(userId, name, image);
        if(num == 1){
            return Result.ok("Successful!","");
        }else {
            return Result.error("Failure!","");
        }
    }



    // Auto Created by Zeng
    @ApiOperation(value = "获取邀请码",httpMethod = "GET",notes = "Auto Creat")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "图像id",required = true)
    })
    @GetMapping("getInvitingCode")
    public Result getInvitingCode(Integer id){
        if(id == null){
            return Result.error("未获取到图像id!","");
        }else {
            return drawPlanformService.getInvitingCode(id);
        }
    }

}
