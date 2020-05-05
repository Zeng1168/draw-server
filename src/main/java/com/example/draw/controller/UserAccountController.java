package com.example.draw.controller;

import com.example.draw.entity.User;
import com.example.draw.service.UserService;
import com.example.draw.utils.DataCheck;
import com.example.draw.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Api(tags = "用户账号（登录、注册）")
@CrossOrigin
@RestController
@RequestMapping("/userAccount/")
public class UserAccountController {

    @Autowired
    AuthenticationManager manager;

    @Autowired
    UserService userService;


    @ApiOperation(value = "密码登录",httpMethod = "POST",notes = "电话号码+密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名/电话号码",required = true),
            @ApiImplicitParam(name = "password",value = "密码",required = true)
    })
    @PostMapping("passwordLogin")
    public Result passwordLogin(String username, String password, HttpServletRequest request){
        Result result = Result.error("系统异常，请稍后重试！","");
        if(username == null || username.equals("")){
            result.setMsg("用户名/电话号码不能为空！");
        }else if(password == null || password.equals("")){
            result.setMsg("密码不能为空！");
        }else if(!DataCheck.passwordCheck(password)){
            result.setMsg("密码错误！");
        }else {
            result = userService.passwordLogin(manager, username, password, request);
        }
        return result;
    }



    @ApiOperation(value = "测试",httpMethod = "GET")
    @GetMapping("/test")
    @PreAuthorize("isAuthenticated()")
    public Result test(){
        return Result.ok("需要登陆才能访问的url");
    }



    @ApiOperation(value = "注销",httpMethod = "POST",notes = "退出登录")
    @PostMapping("/logout")
    @PreAuthorize("isAuthenticated()")
    public Result logout() {
        SecurityContextHolder.clearContext();
        return Result.ok("退出成功","");
    }



    @ApiOperation(value = "用户注册",httpMethod = "POST",notes = "已经获取过验证码，用有效的验证码进行手机注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名,少于16个字符，支持中英文、数字、减号或下划线",required = true),
            @ApiImplicitParam(name = "phone",value = "电话号码"),
            @ApiImplicitParam(name = "password",value = "密码,6~18位之间，必须包含字母和数字",required = true)
    })
    @PostMapping("userSign")
    public Result userSign(User user){
        System.out.println("++++++用户注册" + user.toString());
        Result result = Result.error("系统异常，请稍后重试！","");
        // 数据校验
        if(user.getPhone() == null){
            result.setMsg("请输入电话号码！");
        }else if(!DataCheck.phoneCheck(user.getPhone())){
            result.setMsg("电话号码格式不正确！");
        }else if(userService.phoneUsingCheck(user.getPhone()) > 0){
            result.setMsg("该电话号码已注册！");
        }else if(user.getUsername() == null || user.getUsername().equals("")){
            result.setMsg("请输入用户名！");
        }else if(!DataCheck.neaknameCheck(user.getUsername())){
            result.setMsg("用户名包含特殊字符或超过长度限制!");
        }else if(userService.usernameUsingCheck(user.getUsername()) > 0){
            result.setMsg("该用户名已被占用！");
        }else if(user.getPassword() == null || user.getPassword().equals("")){
            result.setMsg("请输入密码！");
        }else if(!DataCheck.passwordCheck(user.getPassword())) {
            result.setMsg("密码在6~18位之间，必须包含字母和数字！");
        } else{
            result = userService.userSign(user);
        }
        return result;
    }


}
