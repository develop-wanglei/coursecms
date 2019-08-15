package com.newtechcollege.coursecms.controller;

import com.newtechcollege.coursecms.entity.Teacher;
import com.newtechcollege.coursecms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherCtl {

    @Autowired
    private TeacherService teacherService;

    /**
     * 教师列表接口
     */
    @RequestMapping(value = "/select")
    public List selectAll(){
        List<Teacher> list = teacherService.selectTeacherAll();
        return list;
    }
    /**
     * 教师详情接口
     */
    @RequestMapping(value = "/details")
    public Teacher teacherById(int teacherid){
        Teacher teacher = teacherService.selectTeacherById(teacherid);
        return teacher;
    }
    /**
     * 教师姓名模糊查询
     */
    @RequestMapping(value = "/like")
    public List teacherLike(String likename){
        List<Teacher> list = teacherService.selectTeacherLike(likename);
        return list;
    }
    /**
     *新增教师
     */
    @RequestMapping(value = "/insert")
    public int insertTeacher(Teacher teacher){
        Integer integer = teacherService.insertTeacher(teacher);
        return integer;
    }

}
