package com.newtechcollege.cms.dao;

import com.newtechcollege.cms.entity.Chapter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChapterMapper {
    List<Map<String,Object>> list();

    List<Map<String,Object>> search(String title, String courseid);

    Map<String,Object> getChapterById(int id);

    int insert(Chapter chapter);

    int update(Chapter chapter);

    int delete(int id);

    int publish(int id);
}

