package com.newtechcollege.coursecms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Email;

import com.alibaba.fastjson.JSONObject;
import com.newtechcollege.coursecms.dao.ErrMapper;
import com.newtechcollege.coursecms.entity.ErrException;
import com.newtechcollege.coursecms.entity.Test;
import com.newtechcollege.coursecms.myexception.ParameterException;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
    private ErrMapper errMapper;

    @RequestMapping(value = "/validate")
    public String validate(@Valid Test test, BindingResult bindingResult){
        String json = this.goCheck(test,bindingResult);
        return json;
    }
    @RequestMapping(value = "/data")
    public Boolean data(ErrException errException){
            errMapper.insert(errException);
            return true;
    }

    @RequestMapping(value = "/exception")
    public Boolean add(@Email(message = "邮件不合法") String str){

        if(str.length() > 15){
            throw new ParameterException("邮件长度不能超过15位");
        }

        int i = 1/0;

        return true;
    }

    public String goCheck(Test test, BindingResult bindingResult){
        JSONObject json = new JSONObject();
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            
            json.put("code", 1);
            
            StringBuffer sb = new StringBuffer();

            sb.append("error:");
            for(ObjectError error: allErrors){
                sb.append("\n").append(error.getDefaultMessage());
            }
            json.put("errmsg", sb.toString());
        }else{
            json.put("code", 0);
            json.put("data", "测试成功,返回正确的数据");
        }
       
        return json.toJSONString();
    }
}