package com.newtechcollege.coursecms.controller;

import com.newtechcollege.coursecms.entity.Teacher;
import com.newtechcollege.coursecms.service.TeacherService;
import com.newtechcollege.coursecms.util.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
/**
 * 
 * 教师控制层api
  * @return : null
 * @author wanglei
 * @date 2019/8/16 9:39
 */
@RestController
@CrossOrigin(origins = "*")
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
    /**
     * 删除教师
     */
    @RequestMapping(value = "/delete")
    public int deleteTeacher(Integer teacherid){
        return teacherService.deleteTeacherById(teacherid);
    }
    /**
     * 教师头像上传
     */
    @RequestMapping(value = "/teacherUpload",method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        FileInputStream inputStream = (FileInputStream) file.getInputStream();
        String pathUrl = QiniuUtil.uploadImg(inputStream, UUID.randomUUID().toString().substring(0, 8));
        return pathUrl;
    }
    /**
     * 修改教师是否展示
     */
    @RequestMapping(value = "/updateTeacherStatus")
    public int status(Integer teacherid,Integer status){
        return teacherService.updataTeacherStatusById(teacherid,status);
    }
    /**
     * 修改教师信息
     */
    @RequestMapping(value = "/updateTeacher",method = RequestMethod.POST)
    public int updata(Integer teacherid,Teacher teacher){
       return teacherService.updataTeacher(teacherid,teacher);
    }
    /**
     * 修改教师头像
     */
    @RequestMapping(value = "/updateTeacherImg",method = RequestMethod.POST)
    public int updataImg(Integer teacherid,String teacherimgsrc){
        return teacherService.updataTeacherImg(teacherid,teacherimgsrc);
    }
}
