package com.newtechcollege.coursecms.dao;

import java.util.List;

import com.newtechcollege.coursecms.entity.Discover;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  ActivityMapper {

    List<Discover> select();

    Discover getActivityById(int id);

    int insert(Discover discover);

    int update(Discover discover);

    int delete(int id);

    int publish(int id,int status);
}
