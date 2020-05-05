package com.example.draw.controller;

import com.example.draw.entity.LoginLog;
import com.example.draw.service.LoginLogService;
import com.example.draw.utils.Result;
import com.example.draw.utils.UserUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//  Created on 2020-05-04 18:09:07

@Api(tags = "登录日志")
@CrossOrigin
@RestController
@RequestMapping("/loginLog/")
public class LoginLogController {

    @Autowired
    LoginLogService loginLogService;


    // Auto Created by Zeng
    @ApiOperation(value = "selectAll",httpMethod = "GET",notes = "Auto Creat")
    @GetMapping("selectById")
    public Result selectById(){
        Integer userId = UserUtils.getNowUserId();
        if(userId == null){
            return Result.error("Not required userId!");
        }else {
            return Result.ok(loginLogService.selectByUserId(userId));
        }
    }


}
