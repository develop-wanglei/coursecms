package com.newtechcollege.coursecms.service;

import com.newtechcollege.coursecms.entity.Teacher;

import java.util.List;

/**
 *
 * 教师业务逻辑接口
 * @return
 * @author wanglei
 * @creed: 精益求精
 * @date 2019/8/15 17:31
 */
public interface TeacherService {
    List<Teacher> selectTeacherAll();
    Teacher selectTeacherById(int teacherid);
    List<Teacher> selectTeacherLike(String teacherlikename);
    Integer insertTeacher(Teacher teacher);
    Integer deleteTeacherById(Integer teacherId);
    Integer updataTeacherStatusById(Integer teacherid,Integer teacherstatus);
    Integer updataTeacher(Integer id,Teacher teacher);
    Integer updataTeacherImg(Integer id,String teacherImg);
}
