package com.newtechcollege.cms.dao;

import com.newtechcollege.cms.entity.Course;
import com.newtechcollege.cms.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper {
    List<Map<String,Object>> list();

    List<Map<String,Object>> search(String title,String majorid,String teacherid);

    List<Map<String,Object>> all();

    Map<String,Object> getCourseById(int id);

    List<Map<String,Object>> check_list();

    Map<String,Object> getCheckCourseById(int id);

    int insertTeacher(Teacher teacher);

    int insert(Course course);

    int update(Course course);

    int updateByParams(Course course);

    int delete(int id);

    int publish(int id);

    int upload(Integer id,String path);
}

