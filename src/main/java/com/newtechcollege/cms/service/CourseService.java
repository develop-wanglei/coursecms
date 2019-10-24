package com.newtechcollege.cms.service;

import com.newtechcollege.cms.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

     List<Map<String,Object>> list();

     List<Map<String,Object>> search(String title,String majorid,String teacherid);

     List<Map<String,Object>> all();

     Map<String,Object> detail(int id);

     int addTeacher(String name);

     int add(Course course);

     int edit(Course course);

     int update(Course course);

     int delete(int id);

     int publish(int id);

     int upload(Integer id,String path);

     List<Map<String,Object>> check_list();

     Map<String,Object> checkCourseDetail(int id);
}
