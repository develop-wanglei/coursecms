package com.newtechcollege.web.api.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * 视频实体类
  * @return : null
 * @author wanglei
 * @date 2019/8/16 16:16
 */
public class Video {
    private Integer videoid;
    @NotNull(message = "chapter_id 字段缺失或为空")
    private Integer chapter_id;
    @NotNull(message = "course_id 字段缺失或为空")
    private Integer course_id;
    @NotEmpty(message = "videoname 字段缺失或为空")
    private String videoname;
//    @NotEmpty(message = "videourl 字段缺失或为空")
    private String videourl;
    private String videoduration;
    private Integer status;
    private Integer progress;

    public Video() {
    }

    public Video(Integer videoid, Integer chapter_id, Integer course_id, String videoname, String videourl, String videoduration, Integer status, Integer progress) {
        this.videoid = videoid;
        this.chapter_id = chapter_id;
        this.course_id = course_id;
        this.videoname = videoname;
        this.videourl = videourl;
        this.videoduration = videoduration;
        this.status = status;
        this.progress = progress;
    }

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public Integer getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(Integer chapter_id) {
        this.chapter_id = chapter_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getVideoduration() {
        return videoduration;
    }

    public void setVideoduration(String videoduration) {
        this.videoduration = videoduration;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoid=" + videoid +
                ", chapter_id=" + chapter_id +
                ", course_id=" + course_id +
                ", videoname='" + videoname + '\'' +
                ", videourl='" + videourl + '\'' +
                ", videoduration='" + videoduration + '\'' +
                ", status=" + status +
                ", progress=" + progress +
                '}';
    }
}
