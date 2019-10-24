package com.newtechcollege.cms.service.Impl;

import com.newtechcollege.cms.dao.BannerMapper;
import com.newtechcollege.cms.dao.CityMapper;
import com.newtechcollege.cms.entity.Banner;
import com.newtechcollege.cms.entity.BannerItem;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.BannerService;
import com.newtechcollege.cms.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> list() {
        List<Banner> res = bannerMapper.list();
        if(res == null){
            throw new MyException("未查到记录");
        }
        return  res;
    }
    @Override
    public Map<String,Object> getBannerById(int id) {
        Map<String, Object> res = bannerMapper.getBannerById(id);
        if(res == null){
            throw new MyException("未查到记录");
        }
        return  res;
    }
    @Override
    public Map<String,Object> getBannerItemById(int id) {
        Map<String, Object> res = bannerMapper.getBannerItemById(id);
        if(res == null){
            throw new MyException("未查到记录");
        }
        return  res;
    }
    @Override
    public int updateByParams(BannerItem bannerItem){
        int res = bannerMapper.updateByParams(bannerItem);
        if(res != 1){
            throw  new  MyException("更新错误");
        }
        return  res;
    }
    @Override
    public int addBannerItem(BannerItem bannerItem){
        int res = bannerMapper.addBannerItem(bannerItem);
        if(res != 1){
            throw  new  MyException("新增失败,请稍后再试");
        }
        return  res;
    }
}
