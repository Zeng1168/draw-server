package com.example.draw.service;

import com.example.draw.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    public static final String password  = "123456a";
    public static final String passwordEncoder  = "$2a$10$HZZi4ZK8bnw8vG3houAUGOCSgmP5pI4xb4TodhY4MJJHhMN9HRhqi";


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        com.example.draw.entity.User account = null;
        Integer id = null;
        try{
            id = Integer.valueOf(username);
            account = userDao.selectById(id);
        }catch (Exception e){ }


        // 判断用户是否存在
        if(account == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        account.setPassword(passwordEncoder);

        // 添加权限
        authorities.add(new SimpleGrantedAuthority("user"));

        // 返回UserDetails实现类
        return new User(String.valueOf(account.getId()), account.getPassword(), authorities);
    }
}
