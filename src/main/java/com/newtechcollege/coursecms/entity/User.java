package com.newtechcollege.coursecms.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 *
 * 用户实体类
  * @return : null
 * @author wanglei
 * @date 2019/8/16 15:22
 */
public class User {
    private Integer id;
    private String openid;
    private String name;
    private String nick_name;
    private Long mobile;
    private String email;
    @JSONField(serialize = false)
    private String password;
    private String sex;
    private String school;
    private String academy;
    private String major;
    private String position;
    private String work_year;
    private String address;
    private Integer role;
    private Integer create_time;
    private String userpic;
    private Integer status;
    private List<Course> course;
    private List<Video> video;
    public User() {
    }

    public User(Integer id, String openid, String name, String nick_name, Long mobile, String email, String password, String sex, String school, String academy, String major, String position, String work_year, String address, Integer role, Integer create_time, String userpic, Integer status, List<Course> course, List<Video> video) {
        this.id = id;
        this.openid = openid;
        this.name = name;
        this.nick_name = nick_name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.school = school;
        this.academy = academy;
        this.major = major;
        this.position = position;
        this.work_year = work_year;
        this.address = address;
        this.role = role;
        this.create_time = create_time;
        this.userpic = userpic;
        this.status = status;
        this.course = course;
        this.video = video;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWork_year() {
        return work_year;
    }

    public void setWork_year(String work_year) {
        this.work_year = work_year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public List<Video> getVideo() {
        return video;
    }

    public void setVideo(List<Video> video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", name='" + name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                ", academy='" + academy + '\'' +
                ", major='" + major + '\'' +
                ", position='" + position + '\'' +
                ", work_year='" + work_year + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", create_time=" + create_time +
                ", userpic='" + userpic + '\'' +
                ", status=" + status +
                ", course=" + course +
                ", video=" + video +
                '}';
    }
}
