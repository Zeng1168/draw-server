package com.example.draw.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserUtils {
    public static Integer getNowUserId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer id = null;
        try {
            if (principal instanceof UserDetails) {
                id = Integer.parseInt(((UserDetails)principal).getUsername());
            } else {
                id = Integer.parseInt(principal.toString());
            }
        }catch (Exception e){

        }
        return id;
    }
}
