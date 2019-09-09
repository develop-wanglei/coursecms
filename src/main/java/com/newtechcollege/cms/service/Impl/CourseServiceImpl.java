package com.newtechcollege.cms.service.Impl;

import com.newtechcollege.cms.dao.CourseMapper;
import com.newtechcollege.cms.dao.MajorMapper;
import com.newtechcollege.cms.dao.TeacherMapper;
import com.newtechcollege.cms.entity.Course;
import com.newtechcollege.cms.entity.Teacher;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private MajorMapper majorMapper;

    @Override
    public List<Map<String,Object>> list() {

        return courseMapper.list();
    }

    @Override
    public List<Map<String,Object>> search(String title,String majorid,String teacherid) {

        return courseMapper.search(title,majorid,teacherid);
    }

    @Override
    public List<Map<String,Object>> all() {
        return courseMapper.all();
    }

    @Override
    public int addTeacher(String name){
        Teacher teacher = new Teacher();
        teacher.setTeachername(name);
        int i = courseMapper.insertTeacher(teacher);
        if(i != 1){
            throw new MyException("新增教师失败");
        }
        return  teacher.getTeacherid();
    }


    @Override
    public Map<String,Object> detail(int id) {
        return courseMapper.getCourseById(id);
    }

    @Override
    public int add(Course course) {
        int teacher_id = course.getTeacher_id();
        int major_id = course.getMajor_id();
        Teacher teacher = teacherMapper.detail(teacher_id);
        Map<String, Object> majorById = majorMapper.getMajorById(major_id);
        if(teacher == null || majorById == null){
            throw new MyException("教师或者专业参数不合法");
        }
        return courseMapper.insert(course);
    }

    @Override
    public int edit(Course course) {
        int teacher_id = course.getTeacher_id();
        int major_id = course.getMajor_id();
        Teacher teacher = teacherMapper.detail(teacher_id);
        Map<String, Object> majorById = majorMapper.getMajorById(major_id);
        if(teacher == null || majorById == null){
            throw new MyException("教师或者专业参数不合法");
        }
        return courseMapper.update(course);
    }

    @Override
    public int delete(int id){
        return  courseMapper.delete(id);
    }


    @Override
    public int publish(int id){
        return  courseMapper.publish(id);
    }

    @Override
    public int upload(Integer id,String path){
        return  courseMapper.upload(id,path);
    }



}
