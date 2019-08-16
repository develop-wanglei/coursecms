package com.newtechcollege.coursecms.entity;
/**
 *
 * 课程实体类
  * @return : null
 * @author wanglei
 * @date 2019/8/16 15:36
 */
public class Course {
    private Integer courseid;
    private Integer teacher_id;
    private Integer major_id;
    private String coursename;
    private String coursedesc;
    private String imgsrc;
    private Integer coursestatus;
    private Double price;

    public Course() {
    }

    public Course(Integer courseid, Integer teacher_id, Integer major_id, String coursename, String coursedesc, String imgsrc, Integer coursestatus, Double price) {
        this.courseid = courseid;
        this.teacher_id = teacher_id;
        this.major_id = major_id;
        this.coursename = coursename;
        this.coursedesc = coursedesc;
        this.imgsrc = imgsrc;
        this.coursestatus = coursestatus;
        this.price = price;
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

    public Integer getCoursestatus() {
        return coursestatus;
    }

    public void setCoursestatus(Integer coursestatus) {
        this.coursestatus = coursestatus;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
                ", coursestatus=" + coursestatus +
                ", price=" + price +
                '}';
    }
}
