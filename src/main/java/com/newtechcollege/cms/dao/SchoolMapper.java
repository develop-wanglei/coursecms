package com.newtechcollege.cms.dao;

import java.util.List;
import java.util.Map;

import com.newtechcollege.cms.entity.School;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 实训基地Mapper接口 
 */
@Mapper
public interface  SchoolMapper {

    List<Map<String,Object>> list();

    List<Map<String,Object>> search(String title);

    Map<String,Object> getSchoolById(int id);

    int insert(School school);

    int update(School school);

    int delete(int id);

    int publish(int id);

    int upload(Integer id,String path);

}
