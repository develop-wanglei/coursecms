package com.newtechcollege.coursecms.entity;

import javax.validation.constraints.NotNull;

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
    private int teacherid;
    private int userid;
    @NotNull(message = "teachername 字段缺失或为空")
    private String teachername;
    @NotNull(message = "teacherpro 字段缺失或为空")
    private String teacherpro;
    @NotNull(message = "teacherdetail 字段缺失或为空")
    private String teacherdetail;
    @NotNull(message = "teacherimgsrc 字段缺失或为空")
    private String teacherimgsrc;
    private int teacherstatus;
    private String time;

    public Teacher() {
    }

    public Teacher(int teacherid, int userid, String teachername, String teacherpro, String teacherdetail, String teacherimgsrc, int teacherstatus, String time) {
        this.teacherid = teacherid;
        this.userid = userid;
        this.teachername = teachername;
        this.teacherpro = teacherpro;
        this.teacherdetail = teacherdetail;
        this.teacherimgsrc = teacherimgsrc;
        this.teacherstatus = teacherstatus;
        this.time = time;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public int getTeacherstatus() {
        return teacherstatus;
    }

    public void setTeacherstatus(int teacherstatus) {
        this.teacherstatus = teacherstatus;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherid=" + teacherid +
                ", userid=" + userid +
                ", teachername='" + teachername + '\'' +
                ", teacherpro='" + teacherpro + '\'' +
                ", teacherdetail='" + teacherdetail + '\'' +
                ", teacherimgsrc='" + teacherimgsrc + '\'' +
                ", teacherstatus=" + teacherstatus +
                ", time='" + time + '\'' +
                '}';
    }
}
