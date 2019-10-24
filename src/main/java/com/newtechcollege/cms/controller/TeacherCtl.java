package com.newtechcollege.cms.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.newtechcollege.cms.annotation.validate.PostiveInt;
import com.newtechcollege.cms.entity.Teacher;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.TeacherService;
import com.newtechcollege.cms.util.QiniuUtil;
import com.newtechcollege.cms.util.RestfulUtil;

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
    public String selectAll(){
        List<Teacher> list = teacherService.selectTeacherAll();
        if(list == null){
            throw new MyException("没有数据");
        }
        return RestfulUtil.json(list);
    }
    /**
     * 教师详情接口
     */
    @RequestMapping(value = "/detail")
    public String teacherById(@NotNull(message = "id 字段缺失或者为空") Integer id){
            Teacher teacher = teacherService.detail(id);
            if(teacher == null){
                throw new MyException("没有记录");
            }
            return RestfulUtil.json(teacher);
    }
    /**
     * 教师姓名模糊查询
     */
    @RequestMapping(value = "/search")
    public String teacherLike(@NotNull(message = "teacherid不能为空")String likename){
        List<Teacher> list = teacherService.selectTeacherLike(likename);
        if(list == null){
            throw new MyException("没有记录");
        }   
        return RestfulUtil.json(list);
   }

    /**
     * 删除教师
     */
    @RequestMapping(value = "/delete")
    public String deleteTeacher(@NotNull(message = "id 字段为空或者缺失") Integer id){
        Integer integer = teacherService.delete(id);
        if (integer !=1){
            throw new MyException("删除失败");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 发布
     */
    @RequestMapping(value = "/update")
    public String update(@NotNull(message = "id不能为空") Integer id,
                         @NotNull(message = "status 不能为空") Integer status,
                         Teacher teacher){

        if(status == 1 || status == 0){
            teacher.setTeacherid(id);
            teacher.setTeacherstatus(status);
        }else{
            throw new MyException("status 参数不合法");
        }

        Integer integer = teacherService.edit(teacher);
        if (integer!=1){
            throw new MyException("操作失败,请稍后再试");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 教师头像上传
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        FileInputStream inputStream = (FileInputStream) file.getInputStream();
        String pathUrl = QiniuUtil.uploadImg(inputStream, UUID.randomUUID().toString().substring(0, 8));
        return RestfulUtil.json(pathUrl);
    }

    /**
     *新增教师
     */

    @RequestMapping(value = "/insert")
    public String insertTeacher(@Valid Teacher teacher){
        Integer integer = teacherService.insertTeacher(teacher);
        if (integer !=1){
            throw new MyException("新增失败");
        }
        return RestfulUtil.json(integer);
    }
    /**
     * 修改教师信息
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(@PostiveInt Integer id,@Valid Teacher teacher) {
        teacher.setTeacherid(id);
        Integer integer = teacherService.edit(teacher);
        if (integer!=1){
            throw new MyException("修改教师信息失败");
        }
        return RestfulUtil.json(integer);
    }
}
