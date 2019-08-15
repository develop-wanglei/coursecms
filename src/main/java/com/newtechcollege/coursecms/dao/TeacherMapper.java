package com.newtechcollege.coursecms.dao;

import com.newtechcollege.coursecms.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 教师Mapper接口 
 * @return 
 * @author wanglei
 * @creed: 精益求精
 * @date 2019/8/15 17:31
 */
@Mapper
public interface TeacherMapper {
    List<Teacher> selectTeacherAll();
    Teacher selectTeacherById(int teacherid);
    List<Teacher> selectTeacherLike(String teacherlikename);
    Integer insertTeacher(Teacher teacher);
}
