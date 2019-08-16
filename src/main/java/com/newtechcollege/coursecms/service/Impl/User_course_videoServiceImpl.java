package com.newtechcollege.coursecms.service.Impl;

import com.newtechcollege.coursecms.dao.User_course_videoMapper;
import com.newtechcollege.coursecms.entity.Course;
import com.newtechcollege.coursecms.entity.User;
import com.newtechcollege.coursecms.entity.Video;
import com.newtechcollege.coursecms.service.User_course_videoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 用户课程视频业务实现类
  * @return : null
 * @author wanglei
 * @date 2019/8/16 16:38
 */
@Service
public class User_course_videoServiceImpl implements User_course_videoService {

    @Resource
    private User_course_videoMapper mapper;

    @Override
    public List<Course> selectUserCourse(Integer userid) {
        return mapper.selectUserCourse(userid);
    }

    @Override
    public List<Video> selectUserVideo(Integer userid) {
        return mapper.selectUserVideo(userid);
    }

    @Override
    public User selectUser(Integer userid) {
        return mapper.selectUser(userid);
    }
}
