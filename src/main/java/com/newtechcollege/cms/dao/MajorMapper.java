package com.newtechcollege.cms.dao;

import com.newtechcollege.cms.entity.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MajorMapper {

    List<Map<String,Object>> list();

    Map<String,Object> getMajorById(int id);

    List<Map<String,Object>> search(String title);

    int insert(Major major);

    int update(Major major);

    int delete(int id);

    int publish(int id);

    int upload(Integer id,String path);

    int updateCommon(Major major);
}

