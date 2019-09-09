package com.newtechcollege.cms.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
/**
 *
 * 章节实体类
 *
 */
public class Chapter {
    private Integer chapter_id;
    @NotEmpty(message = "chaptername 字段缺失或为空")
    private String chaptername;
    @NotNull(message = "course_id 字段缺失或为空")
    private Integer course_id;
    private List<Video> video;
    public List<Video> getVideo() {
        return video;
    }

    public void setVideo(List<Video> video) {
        this.video = video;
    }

    public Chapter() {
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapter_id=" + chapter_id +
                ", chaptername='" + chaptername + '\'' +
                ", course_id=" + course_id +
                '}';
    }

    public Integer getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(Integer chapter_id) {
        this.chapter_id = chapter_id;
    }
    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }




}
