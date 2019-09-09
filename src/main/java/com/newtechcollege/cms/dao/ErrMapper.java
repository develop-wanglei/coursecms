package com.newtechcollege.cms.dao;

import com.newtechcollege.cms.entity.ErrException;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 活动Mapper接口 
 */
@Mapper
public interface  ErrMapper {

    int insert(ErrException errException);

}
