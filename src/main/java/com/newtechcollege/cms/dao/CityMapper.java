package com.newtechcollege.cms.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 城市Mapper接口
 */
@Mapper
public interface CityMapper {

    List<Map<String,Object>> list();

}
