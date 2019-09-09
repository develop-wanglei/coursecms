package com.newtechcollege.cms.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.newtechcollege.cms.dao.SchoolMapper;
import com.newtechcollege.cms.entity.School;
import com.newtechcollege.cms.service.SchoolService;

import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private SchoolMapper schoolMapper;  

    @Override
    public List<Map<String,Object>> list() {
        return schoolMapper.list();
    }

    @Override
    public List<Map<String,Object>> search(String title) {
        return schoolMapper.search(title);
    }

    @Override
    public Map<String,Object> getOne(int id) {
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
    public int publish(int id) {
        return schoolMapper.publish(id);
    }

    @Override
    public int upload(Integer id,String path){
        return  schoolMapper.upload(id,path);
    }
}
