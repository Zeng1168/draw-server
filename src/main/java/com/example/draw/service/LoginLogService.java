package com.example.draw.service;

import com.example.draw.dao.LoginLogDao;
import com.example.draw.entity.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//  Created on 2020-05-04 18:09:07

@Service
public class LoginLogService {

    @Autowired
    LoginLogDao loginLogDao;


    // Auto Created by Zeng
    public LoginLog selectById(Integer id){
        return loginLogDao.selectById(id);
    }

    // Auto Created by Zeng
    public int insert(LoginLog loginLog){
        return loginLogDao.insertLoginLog(loginLog);
    }


    // Auto Created by Zeng
    public List<LoginLog> selectByUserId(Integer userId){
        return loginLogDao.selectByUserId(userId);
    }



}
