package com.newtechcollege.coursecms.service;

import com.newtechcollege.coursecms.entity.Discover;

import java.util.List;

public interface ActivityService {
    public List<Discover> select() ;

    public Discover getOne(int id) ;

    public int add(Discover discover) ;

    public int edit(Discover discover);

    public int delete(int id) ;

    public int publish(int id,int status) ;
}
