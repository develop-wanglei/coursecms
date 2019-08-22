package com.newtechcollege.coursecms.dao;

import com.newtechcollege.coursecms.entity.Course;
import com.newtechcollege.coursecms.entity.User;
import com.newtechcollege.coursecms.entity.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * 用户课程视频dao接口
  * @return : null
 * @author wanglei
 * @date 2019/8/16 15:21
 */
@Mapper
public interface User_course_videoMapper {

    List<Course> selectUserCourse(Integer userid);
    List<Video> selectUserVideo(Integer userid);
    User selectUser(Integer userid);
    List<User> selectGood(Integer id);

}
