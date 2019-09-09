package com.newtechcollege.cms.service;

import com.newtechcollege.cms.entity.Discover;

import java.util.List;

public interface ActivityService {
     List<Discover> select();

     Discover getOne(int id);

     List<Discover> search(String title) ;

     int add(Discover discover) ;

     int edit(Discover discover);

     int delete(int id) ;

     int publish(int id,int status) ;
}
