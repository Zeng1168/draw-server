package com.example.draw.service;

import com.example.draw.dao.ShapeSphereDao;
import com.example.draw.entity.ShapeSphere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//  Created on 2020-05-06 09:07:06

@Service
public class ShapeSphereService {

    @Autowired
    ShapeSphereDao shapeSphereDao;


    // Auto Created by Zeng
    public ShapeSphere selectById(Integer id){
        return shapeSphereDao.selectById(id);
    }

    // Auto Created by Zeng
    public int insert(ShapeSphere shapeSphere){
        return shapeSphereDao.insertShapeSphere(shapeSphere);
    }



}
