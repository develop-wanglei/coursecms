package com.newtechcollege.cms.service.Impl;

import com.newtechcollege.cms.dao.ChapterMapper;
import com.newtechcollege.cms.dao.CourseMapper;
import com.newtechcollege.cms.dao.VideoMapper;
import com.newtechcollege.cms.entity.Video;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private ChapterMapper chapterMapper;

    @Override
    public List<Map<String,Object>> list() {

        return videoMapper.list();
    }

    @Override
    public List<Map<String,Object>> search(String title,String courseid,String chapterid) {

        return videoMapper.search(title,courseid,chapterid);
    }


    @Override
    public Map<String,Object> detail(int id) {
        return videoMapper.getVideoById(id);
    }

    @Override
    public int add(Video video) {
        validParam(video.getCourse_id(),video.getChapter_id());
        return videoMapper.insert(video);
    }

    @Override
    public int edit(Video video) {
        validParam(video.getCourse_id(),video.getChapter_id());
        return videoMapper.update(video);
    }

    public  void validParam(Integer course_id,Integer chapter_id){
        Map<String, Object> courseById = courseMapper.getCourseById(course_id);
        if(courseById == null){
            throw new MyException("课程参数不合法");
        }
        Map<String, Object> chapterById = chapterMapper.getChapterById(chapter_id);
        if(chapterById == null){
            throw new MyException("章节参数不合法");
        }
    }
    @Override
    public int delete(int id){
        return  videoMapper.delete(id);
    }


    @Override
    public int publish(int id){
        return  videoMapper.publish(id);
    }

    @Override
    public int upload(Integer id,String path){
        return  videoMapper.upload(id,path);
    }



}
