package com.newtechcollege.coursecms.service.Impl;

import com.newtechcollege.coursecms.dao.TeacherMapper;
import com.newtechcollege.coursecms.entity.Teacher;
import com.newtechcollege.coursecms.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * 教师业务逻辑实现接口类
  * @param null : 
  * @return : null
 * @author wanglei
 * @date 2019/8/15 17:43
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;
    
    @Override
    public List<Teacher> selectTeacherAll() {
        return teacherMapper.selectTeacherAll();
    }

    @Override
    public Teacher selectTeacherById(int teacherid) {
        return teacherMapper.selectTeacherById(teacherid);
    }

    @Override
    public List<Teacher> selectTeacherLike(String teacherlikename) {
        teacherlikename="%"+teacherlikename+"%";
        return teacherMapper.selectTeacherLike(teacherlikename);
    }

    @Override
    public Integer insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }
}
