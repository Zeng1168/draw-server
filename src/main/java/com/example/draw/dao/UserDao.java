package com.example.draw.dao;

import com.example.draw.entity.User;
import com.example.draw.dao.dynaSql.UserSql;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


//  Created on 2020-05-04 15:29:00

@Mapper
@Repository
public interface UserDao {


    // Auto Created by Zeng
    @Select("SELECT * FROM user WHERE id=#{id}")
    User selectById(Integer id);

    // Auto Created by Zeng
    @InsertProvider(type = UserSql.class,method = "insertUser")
    int insertUser(User user);

    @UpdateProvider(type = UserSql.class, method = "updateALLUser")
    int updateALLUser(User user);

    // 多条件查询
    @SelectProvider(type = UserSql.class, method = "selectByMutiParamsUser")
    List<User> selectByMutiParamsUser(User user);

    // 通过用户名或电话号码查询用户
    @Select("SELECT id, username, phone, password, is_useful FROM user WHERE username=#{username} OR phone=#{username}")
    List<User> selectByPhoneOrUsername(String username);

    // 查询电话是否有人注册
    @Select("SELECT COUNT(*) FROM user WHERE phone = #{phone}")
    int queryPhoneUsingNum(String phone);

    // 查询用户名是否有人使用
    @Select("SELECT COUNT(*) FROM user WHERE username = #{username}")
    int queryUsernameUsingNum(String phone);


}
