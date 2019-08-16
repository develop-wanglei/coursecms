package com.newtechcollege.coursecms.service;

import com.newtechcollege.coursecms.entity.Course;
import com.newtechcollege.coursecms.entity.User;
import com.newtechcollege.coursecms.entity.Video;

import java.util.List;

/**
 * 
 * 用户课程视频业务逻辑接口 
  * @return : null
 * @author wanglei
 * @date 2019/8/16 16:33
 */
public interface User_course_videoService {
    List<Course> selectUserCourse(Integer userid);
    List<Video> selectUserVideo(Integer userid);
    User selectUser(Integer userid);
}
