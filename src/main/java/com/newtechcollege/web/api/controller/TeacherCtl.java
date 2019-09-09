package com.newtechcollege.web.api.controller;

import com.newtechcollege.web.api.entity.Teacher;
import com.newtechcollege.web.api.myexception.MyException;
import com.newtechcollege.web.api.service.Impl.TeacherServiceImpl;
import com.newtechcollege.web.api.util.RestfulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Validated
@CrossOrigin(origins = "*")
@RequestMapping(value = "/teacher")
public class TeacherCtl {

    @Autowired
    private TeacherServiceImpl teacherService;

    /*
     * 教师列表
     * @return []
     */
    @RequestMapping(value = "/list")
    public String list() {
        List<Teacher> res = teacherService.list();
        if(res == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(res);
    }
}