package com.newtechcollege.coursecms.controller;

import com.alibaba.fastjson.JSONObject;
import com.newtechcollege.coursecms.entity.Course;
import com.newtechcollege.coursecms.entity.User;
import com.newtechcollege.coursecms.entity.Video;
import com.newtechcollege.coursecms.service.User_course_videoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 * 用户控制层 
  * @return : null
 * @author wanglei
 * @date 2019/8/16 17:22
 */
@RestController
@RequestMapping(value = "/user",method = RequestMethod.POST)
public class UserCtl {

    @Autowired
    private User_course_videoService user_course_videoService;


    @RequestMapping(value = "/user_course_video",method = RequestMethod.POST)
    @Transactional
    public String user_course_video(Integer userid){
        JSONObject json = new JSONObject();
        if (userid!=null){
            List<Course> course = user_course_videoService.selectUserCourse(userid);
            List<Video> video = user_course_videoService.selectUserVideo(userid);
            User user = user_course_videoService.selectUser(userid);
            user.setCourse(course);
            user.setVideo(video);
            json.put("code",1);
            json.put("data",user);
            return json.toString();
        }else {
            json.put("code",0);
            json.put("info","传入用户ID为空！");
            return json.toString();
        }
    }
}
