package com.newtechcollege.coursecms.service;

import com.newtechcollege.coursecms.entity.School;

import java.util.List;

public interface SchoolService {
     List<School> select();

     School getOne(int id);

     List<School> search(String title) ;

     int add(School school);

     int edit(School school);

     int delete(int id) ;

     int publish(int id,int status) ;
}
