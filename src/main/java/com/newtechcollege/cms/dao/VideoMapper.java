package com.newtechcollege.cms.dao;

import com.newtechcollege.cms.entity.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface VideoMapper {
    List<Map<String,Object>> list();

    List<Map<String,Object>> search(String title, String courseid,String chapterid);

    Map<String,Object> getVideoById(int id);

    int insert(Video video);

    int update(Video video);

    int delete(int id);

    int publish(int id);

    int upload(Integer id,String path);
}

