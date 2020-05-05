package com.example.draw.service;

import com.example.draw.dao.LoginLogDao;
import com.example.draw.dao.UserDao;
import com.example.draw.entity.LoginLog;
import com.example.draw.entity.User;
import com.example.draw.utils.HttpTools;
import com.example.draw.utils.Result;
import com.example.draw.utils.StatusCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Random;


//  Created on 2020-05-04 15:29:00

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    LoginLogDao loginLogDao;


    // Auto Created by Zeng
    public User selectById(Integer id){
        return userDao.selectById(id);
    }


    public Result passwordLogin(AuthenticationManager manager, String username, String password, HttpServletRequest request){
        List<User> users = userDao.selectByPhoneOrUsername(username);

        if (users.size() == 0){ // 未找到用户
            return Result.error("用户未注册！","");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();    // 加密
        for(User user : users){
            if(encoder.matches(password, user.getPassword())){    // 密码正确
                if (user.getIsUseful()!= 1){    // 用户状态不正常
                    return Result.error(StatusCodeUtil.getUserStatusByCode(user.getIsUseful()), user);
                }else {
                    return login(manager, user, 1, request);
                }
            }
        }

        return Result.error("密码不正确！");
    }


    /**
     * Spring Security鉴权关键代码
     */
    private Result login(AuthenticationManager manage, User user, int type, HttpServletRequest request){
        Result result = null;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();    // 加密
        LoginLog log = new LoginLog();
        log.setTime(new Date());
        log.setUserId(user.getId());
        log.setIpAddress(HttpTools.getRemortIP(request));
        log.setType(type);
        if(loginLogDao.insertLoginLog(log) == 1){
            result = Result.ok("恭喜您，登录成功！ ", user);

            // 构造出一个暂时没有鉴权的 UsernamePasswordAuthenticationToken
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(String.valueOf(user.getId()), MyUserDetailsService.password);

            // 交由AuthenticationManager进行剩下的鉴权处理，得到一个鉴权的Authentication
            Authentication authentication = manage.authenticate(usernamePasswordAuthenticationToken);

            // 将认证信息放入Session中
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else {
            result = Result.error("系统异常，日志写入失败！","");
        }
        return result;
    }


    public int phoneUsingCheck(String phone){
        return userDao.queryPhoneUsingNum(phone);
    }

    public int usernameUsingCheck(String username){
        return userDao.queryUsernameUsingNum(username);
    }

    public Result userSign(User user){
        try{
            // 密码加密
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodePassword = encoder.encode(user.getPassword());
            user.setPassword(encodePassword);
            user.setSignTime(new Date());
            user.setIsUseful(1);
            if(userDao.insertUser(user) == 1){
                return Result.ok("注册成功！", "");
            }else {
                return Result.error("注册失败,请稍后重试！","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("系统异常，请稍后重试！");
        }
    }

    public Result passwordChange(Integer id,String password, String oldPassword){
        User user = userDao.selectById(id);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (user == null){
            return Result.error("用户未注册！", "");
        }else if(!encoder.matches(oldPassword, user.getPassword())){
            return Result.error("密码不正确！", "");
        }else {
            return passwordDoChange(id, password);
        }
    }


    private Result passwordDoChange(Integer id, String password){
        User user = new User();
        user.setId(id);
        // 密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(password);
        user.setPassword(encodePassword);
        if(userDao.updateALLUser(user) == 1){
            return Result.ok("密码修改成功！", "");
        }else {
            return Result.error("密码修改失败！","");
        }
    }

}
