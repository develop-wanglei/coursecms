package com.newtechcollege.cms.service;

import com.newtechcollege.cms.entity.Video;

import java.util.List;
import java.util.Map;

public interface VideoService {

     List<Map<String,Object>> list();

     List<Map<String,Object>> search(String title, String courseid,String chapterid);

     Map<String,Object> detail(int id);

     int add(Video video);

     int edit(Video video);

     int delete(int id);

     int publish(int id);

     int upload(Integer id,String path);
}
