package com.newtechcollege.web.api.dao;

import com.newtechcollege.web.api.entity.ErrException;

import com.newtechcollege.web.api.entity.ErrException;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 活动Mapper接口 
 */
@Mapper
public interface  ErrMapper {

    int insert(ErrException errException);

}
