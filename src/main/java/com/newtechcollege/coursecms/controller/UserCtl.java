package com.newtechcollege.coursecms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.alibaba.fastjson.JSONObject;
import com.newtechcollege.coursecms.entity.Course;
import com.newtechcollege.coursecms.entity.User;
import com.newtechcollege.coursecms.entity.Video;
import com.newtechcollege.coursecms.myexception.MyException;
import com.newtechcollege.coursecms.service.UserService;
import com.newtechcollege.coursecms.service.User_course_videoService;
import com.newtechcollege.coursecms.util.RestfulUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 用户控制层 
  * @return : null
 * @author wanglei
 * @date 2019/8/16 17:22
 */
@RestController
@Validated
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
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
     * 所有用户列表,微信用户列表
     * @param type
     * @return
     */
    @RequestMapping(value ="/list")
    public String list(@NotNull(message = "type 字段缺失") String type){

        List<User> list;

        if("wx".equals(type)){//查询微信用户列表
            list = userService.selectUserWechat();
        }else if("all".equals(type)){//查询所有用户列表
            list = userService.selectUser();
        }else{
            throw new MyException("参数错误");
        }
        if(list == null){
            throw new MyException("用户信息不存在");
        }

        return RestfulUtil.json(list);
   }
   /**
     * 用户总数,微信用户总数
     * @return
     */
    @RequestMapping(value ="/sum")
    public String sum(){

        List<User> user= userService.selectUser();
        List<User> wx= userService.selectUserWechat();
        
        if(user == null || wx == null){
            throw new MyException("用户信息不存在");
        }

        JSONObject json = new JSONObject();
        json.put("userSum", user.size());
        json.put("wechatSum", wx.size());

        return RestfulUtil.json(json);
   }

    /**
     * 用户名模糊查询
     * @param likename
     * @return
     */
   @RequestMapping(value = "/search")
    public String search(@NotNull(message = "缺失likename字段") String likename){

        List<User> list = userService.selectLikeName(likename);
        return RestfulUtil.json(list);

   }

    /**
     * 修改用户状态
     * @param status
     * @param userid
     * @return
     */
   @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String status(@NotNull(message = "type字段 缺失或者为空") String type,@NotNull(message = "userid字段 缺失或者为空") Integer userid){
       Integer status = 0;
       if("delete".equals(type)){
            status = -1;
       }
       Integer res = userService.updateStatus( status , userid );
       if(res != 1){
            throw new MyException("删除失败");
       }
         
       return RestfulUtil.json(res);
   }

}
