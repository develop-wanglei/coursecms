package com.newtechcollege.cms.service.Impl;

import com.newtechcollege.cms.dao.MajorMapper;
import com.newtechcollege.cms.entity.Major;
import com.newtechcollege.cms.service.MajorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MajorServiceImpl implements MajorService {

    @Resource
    private MajorMapper majorMapper;

    @Override
    public List<Map<String,Object>> list() {

        return majorMapper.list();
    }

    @Override
    public List<Map<String,Object>> search(String title) {
        return majorMapper.search(title);
    }


    @Override
    public Map<String,Object> getOne(int id) {
        return majorMapper.getMajorById(id);
    }


    @Override
    public int add(Major major) {
        return majorMapper.insert(major);
    }

    @Override
    public int edit(Major major) {
        return majorMapper.update(major);
    }

    @Override
    public int delete(int id) {
        return majorMapper.delete(id);
    }

    @Override
    public int publish(int id) {
        return majorMapper.publish(id);
    }

    @Override
    public int upload(Integer id,String path){
        return  majorMapper.upload(id,path);
    }

}
