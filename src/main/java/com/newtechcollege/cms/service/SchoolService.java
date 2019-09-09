package com.newtechcollege.cms.service;

import java.util.List;
import java.util.Map;

import com.newtechcollege.cms.entity.School;

public interface SchoolService {
     List<Map<String,Object>> list();

     Map<String,Object> getOne(int id);

     List<Map<String,Object>> search(String title) ;

     int add(School school);

     int edit(School school);

     int delete(int id) ;

     int publish(int id) ;

     int upload(Integer id,String path);
}
