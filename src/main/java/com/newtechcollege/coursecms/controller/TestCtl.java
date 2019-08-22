package com.newtechcollege.coursecms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Email;

import com.newtechcollege.coursecms.annotation.validate.PostiveInt;
import com.newtechcollege.coursecms.myexception.ParameterException;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@Validated
@RequestMapping(value = "/test")
public class TestCtl {


    @Resource
    private HttpServletRequest req;

    //测试异常
    @RequestMapping(value = "/exception")
    public Boolean add(@Email(message = "邮件不合法") String str){

        if(str.length() > 15){
            throw new ParameterException("邮件长度不能超过15位");
        }

        int i = 1/0;

        return true;
    }

    //验证器测试

    @RequestMapping(value = "/validate")
    public Boolean validate(@PostiveInt(message = "参数不合法") Integer id){

        return true;
    }
  
}