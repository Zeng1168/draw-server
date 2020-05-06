package com.example.draw.service;

import com.example.draw.dao.ShapeTriangleDao;
import com.example.draw.entity.ShapeTriangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//  Created on 2020-05-06 09:07:06

@Service
public class ShapeTriangleService {

    @Autowired
    ShapeTriangleDao shapeTriangleDao;


    // Auto Created by Zeng
    public ShapeTriangle selectById(Integer id){
        return shapeTriangleDao.selectById(id);
    }

    // Auto Created by Zeng
    public int insert(ShapeTriangle shapeTriangle){
        return shapeTriangleDao.insertShapeTriangle(shapeTriangle);
    }



}
