package com.newtechcollege.cms.service;

import com.newtechcollege.cms.entity.Teacher;

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

    List<Teacher> selectTeacherLike(String teacherlikename);
    Integer insertTeacher(Teacher teacher);

    Teacher detail(Integer id);

    int delete(Integer id);

    int publish(Integer id) ;

    int edit(Teacher teacher);

    Integer updataTeacherImg(Integer id,String teacherImg);
}
