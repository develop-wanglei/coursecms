package com.newtechcollege.coursecms.service;

import java.util.List;

import javax.annotation.Resource;

import com.newtechcollege.coursecms.dao.ActivityMapper;
import com.newtechcollege.coursecms.entity.Discover;

import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Resource
    private ActivityMapper activityMapper;  

    public List<Discover> select() {
        return activityMapper.select();
    }

    public Discover getOne(int id) {
        return activityMapper.getActivityById(id);
    }

    public int add(Discover discover) {
        return activityMapper.insert(discover);
    }

    public int edit(Discover discover) {
        return activityMapper.update(discover);
    }

    public int delete(int id) {
        return activityMapper.delete(id);
    }

    public int publish(int id,int status) {
        return activityMapper.publish(id,status);
    }
}
