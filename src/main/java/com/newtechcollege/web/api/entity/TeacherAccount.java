package com.newtechcollege.web.api.entity;

import org.apache.ibatis.annotations.Mapper;
/**
 *
 * 教师账号实体类
  * @param null :
  * @return : null
 * @author wanglei
 * @date 2019/8/15 18:00
 */
@Mapper
public class TeacherAccount {
    private int id;
    private String teacher_account;
    private String teacher_password;
    private String teacher_tel;
    private String wechat;
    private String email;
    private String create_time;

    public TeacherAccount() {
    }

    public TeacherAccount(int id, String teacher_account, String teacher_password, String teacher_tel, String wechat, String email, String create_time) {
        this.id = id;
        this.teacher_account = teacher_account;
        this.teacher_password = teacher_password;
        this.teacher_tel = teacher_tel;
        this.wechat = wechat;
        this.email = email;
        this.create_time = create_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher_account() {
        return teacher_account;
    }

    public void setTeacher_account(String teacher_account) {
        this.teacher_account = teacher_account;
    }

    public String getTeacher_password() {
        return teacher_password;
    }

    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }

    public String getTeacher_tel() {
        return teacher_tel;
    }

    public void setTeacher_tel(String teacher_tel) {
        this.teacher_tel = teacher_tel;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "TeacherAccount{" +
                "id=" + id +
                ", teacher_account='" + teacher_account + '\'' +
                ", teacher_password='" + teacher_password + '\'' +
                ", teacher_tel='" + teacher_tel + '\'' +
                ", wechat='" + wechat + '\'' +
                ", email='" + email + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
