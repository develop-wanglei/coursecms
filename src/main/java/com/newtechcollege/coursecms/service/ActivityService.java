package com.newtechcollege.coursecms.service;

import com.newtechcollege.coursecms.entity.Discover;

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
