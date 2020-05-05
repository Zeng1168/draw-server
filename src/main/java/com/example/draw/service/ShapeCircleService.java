package com.example.draw.service;

import com.example.draw.dao.ShapeCircleDao;
import com.example.draw.entity.ShapeCircle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


//  Created on 2020-05-04 20:01:19

@Service
public class ShapeCircleService {

    @Autowired
    ShapeCircleDao shapeCircleDao;


    // Auto Created by Zeng
    public ShapeCircle selectById(Integer id){
        return shapeCircleDao.selectById(id);
    }

    // Auto Created by Zeng
    public int insert(ShapeCircle shapeCircle){
        shapeCircle.setTime(new Date());
        return shapeCircleDao.insertShapeCircle(shapeCircle);
    }


    public List<ShapeCircle> selectByUser(Integer userId){
        return shapeCircleDao.selectByUser(userId);
    }

}
