package com.example.draw.service;

import com.example.draw.dao.DrawPlanformDao;
import com.example.draw.entity.DrawPlanform;
import com.example.draw.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;


//  Created on 2020-05-04 19:11:19

@Service
public class DrawPlanformService {

    @Autowired
    DrawPlanformDao drawPlanformDao;


    // Auto Created by Zeng
    public DrawPlanform selectById(Integer id){
        return drawPlanformDao.selectById(id);
    }

    // Auto Created by Zeng
    public int insert(Integer userId, String name, String image){
        DrawPlanform drawPlanform = new DrawPlanform();
        drawPlanform.setUserId(userId);
        drawPlanform.setName(name);
        drawPlanform.setImage(image);
        drawPlanform.setTime(new Date());
        drawPlanform.setIsUseful(1);
        return drawPlanformDao.insertDrawPlanform(drawPlanform);
    }


    public List<DrawPlanform> selectByUser(Integer userId){
        return drawPlanformDao.selectByUser(userId);
    }

    public Result getInvitingCode(Integer id){
        DrawPlanform drawPlanform = drawPlanformDao.selectById(id);
        if(drawPlanform == null){
            return Result.error("未找到图像！", "");
        }else if(drawPlanform.getInvitingCode() == null || drawPlanform.getInvitingCode() < 1){
            Integer code = id*10000 + radonInvitingCode();
            int num = drawPlanformDao.updateInvitingCode(id, code);
            if(num ==1){
                return Result.ok("成功生成邀请码！", code);
            }else return Result.error("邀请码生成失败，请重试！");
        }else{
            return Result.ok("已有邀请码！", drawPlanform.getInvitingCode());
        }
    }


    // 生成邀请码
    private Integer radonInvitingCode(){
        Integer code = 0;
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            code = (code*10) + random.nextInt(9);
        }
        return code;
    }



}
