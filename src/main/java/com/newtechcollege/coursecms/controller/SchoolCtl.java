package com.newtechcollege.coursecms.controller;

import java.util.List;

import com.newtechcollege.coursecms.entity.School;
import com.newtechcollege.coursecms.service.Impl.SchoolServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/school")
public class SchoolCtl {

   
    @Autowired
    private SchoolServiceImpl schoolService;
    /**
     * 活动列表
     * @return []
     */
    @RequestMapping(value = "/list")
    public List<School> select() {
        return schoolService.select();
    }
   
}