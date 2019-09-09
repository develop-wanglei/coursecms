package com.newtechcollege.cms.service.Impl;

import com.newtechcollege.cms.dao.CityMapper;
import com.newtechcollege.cms.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;

    @Override
    public List<Map<String,Object>> list() {
        return cityMapper.list();
    }

}
