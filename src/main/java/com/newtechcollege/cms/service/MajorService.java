package com.newtechcollege.cms.service;

import com.newtechcollege.cms.entity.Major;

import java.util.List;
import java.util.Map;

public interface MajorService {

     List<Map<String,Object>> list();

     Map<String,Object> getOne(int id);

     List<Map<String,Object>> search(String title) ;

     int add(Major major);

     int edit(Major major);

     int delete(int id) ;

     int publish(int id) ;

     int upload(Integer id,String path);
}
