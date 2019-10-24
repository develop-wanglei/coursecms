package com.newtechcollege.cms.dao;

import com.newtechcollege.cms.entity.Banner;
import com.newtechcollege.cms.entity.BannerItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 轮播图Mapper接口
 */
@Mapper
public interface BannerMapper {

    List<Banner> list();

    Map<String,Object> getBannerById(int id);

    Map<String,Object> getBannerItemById(int id);

    int updateByParams(BannerItem bannerItem);

    int addBannerItem(BannerItem bannerItem);
}
