package com.example.draw.service;

import com.example.draw.dao.ShapeBoxDao;
import com.example.draw.entity.ShapeBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//  Created on 2020-05-06 09:07:06

@Service
public class ShapeBoxService {

    @Autowired
    ShapeBoxDao shapeBoxDao;


    // Auto Created by Zeng
    public ShapeBox selectById(Integer id){
        return shapeBoxDao.selectById(id);
    }

    // Auto Created by Zeng
    public int insert(ShapeBox shapeBox){
        return shapeBoxDao.insertShapeBox(shapeBox);
    }



}
