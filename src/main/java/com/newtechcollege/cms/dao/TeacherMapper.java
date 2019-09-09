package com.newtechcollege.cms.dao;

import com.newtechcollege.cms.entity.Teacher;
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

    List<Teacher> selectTeacherLike(String teacherlikename);
    Integer insertTeacher(Teacher teacher);

    Teacher detail(Integer id);

    int delete(Integer id);

    int publish(Integer id);

    int update(Teacher teacher);

    Integer updataTeacherImg(Integer id,String teacherImg);
}
