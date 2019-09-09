package com.newtechcollege.cms.service;

import java.util.List;
import java.util.Map;

import com.newtechcollege.cms.entity.Col;

public interface ColService {
     List<Map<String,Object>> list();

     Map<String,Object> getOne(int id);

     List<Map<String,Object>> search(String title) ;

     int add(Col col);

     int edit(Col col);

     int delete(int id) ;

     int publish(int id) ;

     int upload(Integer id,String path);
}
