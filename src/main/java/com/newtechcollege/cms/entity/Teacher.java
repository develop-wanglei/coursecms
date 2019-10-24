package com.newtechcollege.cms.entity;

import javax.validation.constraints.NotBlank;

/**
 *
 * 教师实体类
 * 
 * @return
 * @author wanglei
 * @creed: Talk is cheap,show me the code
 * @date 2019/8/15 17:12
 */
public class Teacher {
    private Integer teacherid;
    @NotBlank(message = "teachername 字段缺失或为空")
    private String teachername;
    @NotBlank(message = "teacherpro 字段缺失或为空")
    private String teacherpro;
    @NotBlank(message = "teacherdetail 字段缺失或为空")
    private String teacherdetail;
    @NotBlank(message = "teacherimgsrc 字段缺失或为空")
    private String teacherimgsrc;
    private String create_time;
    private String update_time;
    private Integer teacherstatus;
    private String time;

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public Teacher() {
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getTeacherstatus() {
        return teacherstatus;
    }

    public void setTeacherstatus(Integer teacherstatus) {
        this.teacherstatus = teacherstatus;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getTeacherpro() {
        return teacherpro;
    }

    public void setTeacherpro(String teacherpro) {
        this.teacherpro = teacherpro;
    }

    public String getTeacherdetail() {
        return teacherdetail;
    }

    public void setTeacherdetail(String teacherdetail) {
        this.teacherdetail = teacherdetail;
    }

    public String getTeacherimgsrc() {
        return teacherimgsrc;
    }

    public void setTeacherimgsrc(String teacherimgsrc) {
        this.teacherimgsrc = teacherimgsrc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
