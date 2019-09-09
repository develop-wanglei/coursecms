package com.newtechcollege.cms.service;

import com.newtechcollege.cms.entity.Chapter;

import java.util.List;
import java.util.Map;

public interface ChapterService {

     List<Map<String,Object>> list();

     List<Map<String,Object>> search(String title, String courseid);

     Map<String,Object> detail(int id);

     int add(Chapter chapter);

     int edit(Chapter chapter);

     int delete(int id);

     int publish(int id);


}
