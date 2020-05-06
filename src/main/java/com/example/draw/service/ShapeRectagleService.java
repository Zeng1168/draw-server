package com.example.draw.service;

import com.example.draw.dao.ShapeRectagleDao;
import com.example.draw.entity.ShapeRectagle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//  Created on 2020-05-06 09:07:06

@Service
public class ShapeRectagleService {

    @Autowired
    ShapeRectagleDao shapeRectagleDao;


    // Auto Created by Zeng
    public ShapeRectagle selectById(Integer id){
        return shapeRectagleDao.selectById(id);
    }

    // Auto Created by Zeng
    public int insert(ShapeRectagle shapeRectagle){
        return shapeRectagleDao.insertShapeRectagle(shapeRectagle);
    }



}
