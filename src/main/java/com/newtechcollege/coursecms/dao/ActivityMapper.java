package com.newtechcollege.coursecms.dao;

import java.util.List;

import com.newtechcollege.coursecms.entity.Discover;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 活动Mapper接口 
 */
@Mapper
public interface  ActivityMapper {

    List<Discover> select();

    List<Discover> search(String title);

    Discover getActivityById(int id);

    int insert(Discover discover);

    int update(Discover discover);

    int delete(int id);

    int publish(int id,int status);
}
