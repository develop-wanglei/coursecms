package com.newtechcollege.cms.service.Impl;

import com.newtechcollege.cms.dao.TeacherMapper;
import com.newtechcollege.cms.entity.Teacher;
import com.newtechcollege.cms.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * 教师业务逻辑实现接口类
  * @param :
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
    public List<Teacher> selectTeacherLike(String teacherlikename) {
        teacherlikename="%"+teacherlikename+"%";
        return teacherMapper.selectTeacherLike(teacherlikename);
    }

    @Override
    public Integer insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }

    @Override
    public int edit(Teacher teacher) {
        return teacherMapper.updateByParams(teacher);
    }


    @Override
    public Teacher detail(Integer id) {
        return teacherMapper.detail(id);
    }


    @Override
    public int delete(Integer id) {
        return teacherMapper.delete(id);
    }

    @Override
    public Integer updataTeacherImg(Integer id, String teacherImg) {
        return teacherMapper.updataTeacherImg(id,teacherImg);
    }
}
