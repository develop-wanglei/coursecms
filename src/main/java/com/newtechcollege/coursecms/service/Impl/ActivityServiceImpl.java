package com.newtechcollege.coursecms.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.newtechcollege.coursecms.dao.ActivityMapper;
import com.newtechcollege.coursecms.entity.Discover;

import com.newtechcollege.coursecms.service.ActivityService;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;  

    @Override
    public List<Discover> select() {
        return activityMapper.select();
    }

    @Override
    public List<Discover> search(String title) {
        return activityMapper.search(title);
    }

    @Override
    public Discover getOne(int id) {
        return activityMapper.getActivityById(id);
    }

    @Override
    public int add(Discover discover) {
        return activityMapper.insert(discover);
    }

    @Override
    public int edit(Discover discover) {
        return activityMapper.update(discover);
    }

    @Override
    public int delete(int id) {
        return activityMapper.delete(id);
    }

    @Override
    public int publish(int id,int status) {
        return activityMapper.publish(id,status);
    }
}
