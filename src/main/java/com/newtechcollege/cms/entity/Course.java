package com.newtechcollege.cms.entity;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * 课程实体类
  * @return : null
 * @author wanglei
 * @date 2019/8/16 15:36
 */
public class Course {
    private Integer courseid;
    @NotNull(message = "teacher_id 字段缺失或为空")
    private Integer teacher_id;
    @NotNull(message = "major_id 字段缺失或为空")
    private Integer major_id;
//    @NotNull(message = "type_id 字段缺失或为空")
    private Integer type_id;




    @NotEmpty(message = "coursename 字段缺失或为空")
    private String coursename;
    @NotEmpty(message = "coursedesc 字段缺失或为空")
    private String coursedesc;
    @NotEmpty(message = "imgsrc 字段缺失或为空")
    private String imgsrc;
    private Integer status;
    @NotNull(message = "price 字段缺失或为空")
    private Double price;
    private Teacher teacher;
    private Major major;
    private CourseType courseType;
    private List<Chapter> chapter;
    private List<Video> video;



    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Chapter> getChapter() {
        return chapter;
    }

    public void setChapter(List<Chapter> chapter) {
        this.chapter = chapter;
    }

    public Course() {

    }

    public Course(List<Video> video,Integer courseid, Integer teacher_id, Integer major_id, String coursename, String coursedesc, String imgsrc, Integer status, Double price) {
        this.courseid = courseid;
        this.teacher_id = teacher_id;
        this.major_id = major_id;
        this.coursename = coursename;
        this.coursedesc = coursedesc;
        this.imgsrc = imgsrc;
        this.status = status;
        this.price = price;
        this.video=video;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getMajor_id() {
        return major_id;
    }

    public void setMajor_id(Integer major_id) {
        this.major_id = major_id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedesc() {
        return coursedesc;
    }

    public void setCoursedesc(String coursedesc) {
        this.coursedesc = coursedesc;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Video> getVideo() {
        return video;
    }

    public void setVideo(List<Video> video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", teacher_id=" + teacher_id +
                ", major_id=" + major_id +
                ", coursename='" + coursename + '\'' +
                ", coursedesc='" + coursedesc + '\'' +
                ", imgsrc='" + imgsrc + '\'' +
                ", status=" + status +
                ", price=" + price +
                ", video=" + video +
                '}';
    }
}
