package com.newtechcollege.cms.service;

import com.newtechcollege.cms.entity.Banner;
import com.newtechcollege.cms.entity.BannerItem;

import java.util.List;
import java.util.Map;

public interface BannerService {

     List<Banner> list();

     Map<String,Object> getBannerById(int id);

     Map<String,Object> getBannerItemById(int id);

     int updateByParams(BannerItem bannerItem);
     int addBannerItem(BannerItem bannerItem);
}
