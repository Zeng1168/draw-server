package com.example.draw.dao;

import com.example.draw.entity.DrawPlanform;
import com.example.draw.dao.dynaSql.DrawPlanformSql;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Repository;

import java.util.List;


//  Created on 2020-05-04 19:11:19

@Mapper
@Repository
public interface DrawPlanformDao {


    // Auto Created by Zeng
    @Select("SELECT * FROM draw_planform WHERE id=#{id}")
    DrawPlanform selectById(Integer id);

    // Auto Created by Zeng
    @InsertProvider(type = DrawPlanformSql.class,method = "insertDrawPlanform")
    int insertDrawPlanform(DrawPlanform drawPlanform);


    @Select("SELECT * FROM draw_planform WHERE user_id=#{userId}")
    List<DrawPlanform> selectByUser(Integer userId);

    @Update("UPDATE draw_planform SET inviting_code = #{invitingCode} WHERE id = #{id}")
    int updateInvitingCode(Integer id, Integer invitingCode);

}
