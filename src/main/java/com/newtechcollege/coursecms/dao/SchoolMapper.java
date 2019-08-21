package com.newtechcollege.coursecms.dao;

import java.util.List;

import com.newtechcollege.coursecms.entity.School;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 活动Mapper接口 
 */
@Mapper
public interface  SchoolMapper {

    List<School> select();

    List<School> search(String title);

    School getSchoolById(int id);

    int insert(School school);

    int update(School school);

    int delete(int id);

    int publish(int id,int status);
}
