package com.newtechcollege.coursecms.controller;

import com.alibaba.fastjson.JSONObject;
import com.newtechcollege.coursecms.entity.Course;
import com.newtechcollege.coursecms.entity.User;
import com.newtechcollege.coursecms.entity.Video;
import com.newtechcollege.coursecms.service.UserService;
import com.newtechcollege.coursecms.service.User_course_videoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    @Autowired
    private UserService userService;

    /**
     * 查看用户课程和视频
     * @param userid
     * @return
     */
    @RequestMapping(value = "/user_course_video",method = RequestMethod.POST)
    @Transactional
    public String user_course_video(Integer userid){
        JSONObject json = new JSONObject();
        if (userid!=null){
            List<Course> course = user_course_videoService.selectUserCourse(userid);
            List<Video> video = user_course_videoService.selectUserVideo(userid);
            User user = user_course_videoService.selectUser(userid);
            if ( user!=null) {
                List<Video> list = new ArrayList<>();
                int count = 0;
                if (course.size()>1 && video.size()>1){
                for (Course c : course) {
                    for (Video v : video) {
                        if (c.getCourseid() == v.getCourse_id()) {
                            list.add(v);
                        }
                        count++;
                    }
                    if (count <= video.size()) {
                        c.setVideo(list);
                    }
                }
                if (course.size() > 0) {
                    user.setCourse(course);
                }
            }
                json.put("code",1);
                json.put("data",user);
            }else {
                json.put("code",0);
                json.put("info","未查到数据");
            }
            return json.toString();
        }else {
            json.put("code",0);
            json.put("info","传入用户ID为空！");
            return json.toString();
        }
    }

    /**
     * 查看所有用户，微信用户和所有用户
     * @param title
     * @return
     */
    @RequestMapping(value ="/selectUser",method = RequestMethod.POST)
    public String user(String title){
        JSONObject json = new JSONObject();
        if(!"".equals(title)){
            if ("wx".equals(title)){
                List<User> wechat = userService.selectUserWechat();
                if (wechat!=null){
                    json.put("code",1);
                    json.put("data",wechat);
                    json.put("info","微信用户");
                }else {
                    json.put("code",0);
                    json.put("info","查询数据出现错误");
                }
                return json.toString();
            }else {
                List<User> users = userService.selectUser();
                if (users!=null){
                    json.put("code",1);
                    json.put("data",users);
                    json.put("info","所有用户");
                }else {
                    json.put("code",0);
                    json.put("info","查询数据出现错误");
                }
                return json.toString();
            }
        }else {
            json.put("code",0);
            json.put("info","传入title为空");
            return json.toString();
        }
   }

    /**
     * 用户名模糊查询
     * @param likename
     * @return
     */
   @RequestMapping(value = "/likeName",method = RequestMethod.POST)
    public String likename(String likename){
        JSONObject json = new JSONObject();
        if(!"".equals(likename)){
            List<User> likeName = userService.selectLikeName(likename);
            if (likeName!=null){
                json.put("code",1);
                json.put("data",likeName);
            }else {
                json.put("code",0);
                json.put("info","查询数据出现错误");
            }
            return json.toString();
        }else {
            json.put("code",0);
            json.put("info","传入参数为空");
            return json.toString();
        }
   }

    /**
     * 修改用户状态
     * @param status
     * @param userid
     * @return
     */
   @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    public String status(Integer status,Integer userid){
       JSONObject json = new JSONObject();
       if (status !=null && userid !=null){
           Integer integer = userService.updateStatus(status, userid);
           if(integer>0){
               json.put("code",1);
               json.put("info","修改成功");
           }else {
               json.put("code",0);
               json.put("info","修改失败");
           }
       }else {
           json.put("code",0);
           json.put("info","传入数值为空");
       }
       return json.toString();
   }

}
