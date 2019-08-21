package com.newtechcollege.coursecms.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.newtechcollege.coursecms.dao.SchoolMapper;
import com.newtechcollege.coursecms.entity.School;
import com.newtechcollege.coursecms.service.SchoolService;

import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private SchoolMapper schoolMapper;  

    @Override
    public List<School> select() {
        return schoolMapper.select();
    }

    @Override
    public List<School> search(String title) {
        return schoolMapper.search(title);
    }

    @Override
    public School getOne(int id) {
        return schoolMapper.getSchoolById(id);
    }

    @Override
    public int add(School School) {
        return schoolMapper.insert(School);
    }

    @Override
    public int edit(School School) {
        return schoolMapper.update(School);
    }

    @Override
    public int delete(int id) {
        return schoolMapper.delete(id);
    }

    @Override
    public int publish(int id,int status) {
        return schoolMapper.publish(id,status);
    }
}
