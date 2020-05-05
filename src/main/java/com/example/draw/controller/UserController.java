package com.example.draw.controller;

import com.example.draw.service.UserService;
import com.example.draw.utils.DataCheck;
import com.example.draw.utils.Result;
import com.example.draw.utils.UserUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//  Created on 2020-05-04 15:29:00

@Api(tags = "用户")
@CrossOrigin
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;


    // Auto Created by Zeng
    @ApiOperation(value = "查询用户详细信息",httpMethod = "GET",notes = "Auto Creat")
    @GetMapping("selectDetails")
    public Result selectDetails(){
        Integer id = UserUtils.getNowUserId();
        if(id == null){
            return Result.error("Not required id!");
        }else {
            return Result.ok(userService.selectById(id));
        }
    }


    @ApiOperation(value = "密码修改",httpMethod = "POST",notes = "电话号码+密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "password",value = "密码",required = true),
            @ApiImplicitParam(name = "oldPassword",value = "旧密码",required = true)
    })
    @PostMapping("passwordChange")
    public Result passwordChange(String password, String oldPassword){
        Integer id = UserUtils.getNowUserId();
        Result result = Result.error("系统异常，请稍后重试！","");
        if(password == null){
            result.setMsg("新密码不能为空！");
        }else if(!DataCheck.passwordCheck(password)){
            result.setMsg("新密码格式不正确！");
        }else if(oldPassword == null){
            result.setMsg("旧密码不能为空！");
        }else if(!DataCheck.passwordCheck(oldPassword)){
            result.setMsg("旧密码格式不正确！");
        }else {
            result = userService.passwordChange(id, password, oldPassword);
        }
        return result;
    }


}
