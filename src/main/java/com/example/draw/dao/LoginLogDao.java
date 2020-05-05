package com.example.draw.dao;

import com.example.draw.entity.LoginLog;
import com.example.draw.dao.dynaSql.LoginLogSql;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


//  Created on 2020-05-04 18:09:07

@Mapper
@Repository
public interface LoginLogDao {


    // Auto Created by Zeng
    @Select("SELECT * FROM login_log WHERE id=#{id}")
    LoginLog selectById(Integer id);

    // Auto Created by Zeng
    @InsertProvider(type = LoginLogSql.class,method = "insertLoginLog")
    int insertLoginLog(LoginLog loginLog);


    @Select("SELECT * FROM login_log WHERE user_id=#{userId}")
    List<LoginLog> selectByUserId(Integer userId);



}
