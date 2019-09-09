package com.newtechcollege.cms.service.Impl;

import com.newtechcollege.cms.dao.ChapterMapper;
import com.newtechcollege.cms.dao.CourseMapper;
import com.newtechcollege.cms.entity.Chapter;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.ChapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Resource
    private ChapterMapper chapterMapper;
    @Resource
    private CourseMapper courseMapper;

    @Override
    public List<Map<String,Object>> list() {

        return chapterMapper.list();
    }

    @Override
    public List<Map<String,Object>> search(String title,String courseid) {

        return chapterMapper.search(title,courseid);
    }


    @Override
    public Map<String,Object> detail(int id) {
        return chapterMapper.getChapterById(id);
    }


    @Override
    public int add(Chapter chapter) {
        int course_id = chapter.getCourse_id();
        Map<String, Object> courseById = courseMapper.getCourseById(course_id);
        if(courseById == null){
            throw new MyException("课程参数不合法");
        }
        return chapterMapper.insert(chapter);
    }

    @Override
    public int edit(Chapter chapter) {
        int course_id = chapter.getCourse_id();
        Map<String, Object> courseById = courseMapper.getCourseById(course_id);
        if(courseById == null){
            throw new MyException("课程参数不合法");
        }
        return chapterMapper.update(chapter);
    }

    @Override
    public int delete(int id){
        return  chapterMapper.delete(id);
    }


    @Override
    public int publish(int id){
        return  chapterMapper.publish(id);
    }




}
