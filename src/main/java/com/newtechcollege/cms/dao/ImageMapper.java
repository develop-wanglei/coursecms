package com.newtechcollege.cms.dao;

import com.newtechcollege.cms.entity.Banner;
import com.newtechcollege.cms.entity.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 图片 Mapper接口
 */
@Mapper
public interface ImageMapper {

    int insert(Image image);
}
