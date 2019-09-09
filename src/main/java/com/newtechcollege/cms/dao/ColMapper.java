package com.newtechcollege.cms.dao;

import java.util.List;
import java.util.Map;

import com.newtechcollege.cms.entity.Col;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 实习基地Mapper接口 
 */
@Mapper
public interface  ColMapper {

    List<Map<String,Object>> list();

    List<Map<String,Object>> search(String title);

    Map<String,Object> getColById(int id);

    int insert(Col col);

    int update(Col col);

    int delete(int id);

    int publish(int id);

    int upload(Integer id,String path);
}
