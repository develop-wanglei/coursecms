package com.newtechcollege.coursecms.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.newtechcollege.coursecms.annotation.validate.PostiveInt;
import com.newtechcollege.coursecms.entity.Teacher;
import com.newtechcollege.coursecms.myexception.MyException;
import com.newtechcollege.coursecms.service.TeacherService;
import com.newtechcollege.coursecms.util.QiniuUtil;
import com.newtechcollege.coursecms.util.RestfulUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * 教师控制层api
  * @return : null
 * @author wanglei
 * @date 2019/8/16 9:39
 */

@RestController
@CrossOrigin(origins = "*")
@Validated
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
        if(list == null){
            throw new MyException("没有数据");
        }
        return list;
    }
    /**
     * 教师详情接口
     */
    @RequestMapping(value = "/details")
    public Teacher teacherById(@NotNull(message = "teacherid不能为空！") Integer teacherid){
            Teacher teacher = teacherService.selectTeacherById(teacherid);
            if (teacher == null){
                throw new MyException("没有查询到数据");
            }
            return teacher;
    }
    /**
     * 教师姓名模糊查询
     */
    @RequestMapping(value = "/like")
    public List teacherLike(@NotBlank(message = "likename不能为空") String likename){
        List<Teacher> list = teacherService.selectTeacherLike(likename);
        if (list == null){
            throw new MyException("没有查询到数据");
        }
        return list;
        }
        /**
     *新增教师
     */

    @RequestMapping(value = "/insert")
    public int insertTeacher(@Valid Teacher teacher){
        Integer integer = teacherService.insertTeacher(teacher);
        if (integer !=1){
            throw new MyException("新增失败");
        }
        return integer;
    }
    /**
     * 删除教师
     */
    @RequestMapping(value = "/delete")
    public int deleteTeacher(@NotNull(message = "teacherid不能为空") Integer teacherid){
        Integer integer = teacherService.deleteTeacherById(teacherid);
        if (integer !=1){
            throw new MyException("删除失败");
        }
        return integer;
    }
    /**
     * 教师头像上传
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        FileInputStream inputStream = (FileInputStream) file.getInputStream();
        String pathUrl = QiniuUtil.uploadImg(inputStream, UUID.randomUUID().toString().substring(0, 8));
        return pathUrl;
    }
    /**
     * 修改教师是否展示
     */
    @RequestMapping(value = "/updateTeacherStatus")
    public int status(@NotNull(message = "teacherid不能为空") Integer teacherid,@NotNull(message = "status不能为空") Integer status){
        Integer integer = teacherService.updataTeacherStatusById(teacherid, status);
        if (integer!=1){
            throw new MyException("修改失败");
        }
        return integer;
    }
    /**
     * 修改教师信息
     */
    @RequestMapping(value = "/updateTeacher",method = RequestMethod.POST)
    public int updata(@PostiveInt Integer teacherid,@Valid Teacher teacher) {
        Integer integer = teacherService.updataTeacher(teacherid, teacher);
        if (integer!=1){
            throw new MyException("修改教师信息失败");
        }
        return integer;

    }
       /**
     * 修改教师头像
     */
    @RequestMapping(value = "/updateTeacherImg",method = RequestMethod.POST)
    public int updataImg(@NotNull(message = "teacherid不能为空") Integer teacherid,@NotBlank(message = "teacherimgsrc不能为空") String teacherimgsrc){

        int res = teacherService.updataTeacherImg(teacherid,teacherimgsrc);
        if(res != 1){
            throw  new MyException("修改教师失败");
        }
        return res;
    }
}
