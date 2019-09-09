package com.newtechcollege.web.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;

/**
 *
 * admin实体类
  * @return : null
 * @author wanglei
 * @date 2019/8/23 16:36
 */
public class Admin {
    private Long admin_id;
    @NotBlank(message = "username 字段缺失或为空")
    private String username;
    @NotBlank(message = "password 字段缺失或为空")
    @JSONField(serialize = false)
    private String password;
    private String lastloginip;
    private Integer lastlogintime;
    private String email;
    private String realname;
    private Integer status;
    private Integer scope;

    public Admin() {
    }

    public Admin(Long admin_id, String username,String password , String lastloginip, Integer lastlogintime, String email, String realname, Integer status, Integer scope) {
        this.admin_id = admin_id;
        this.username = username;
        this.password=password;
        this.lastloginip = lastloginip;
        this.lastlogintime = lastlogintime;
        this.email = email;
        this.realname = realname;
        this.status = status;
        this.scope = scope;
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }

    public Integer getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Integer lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastloginip='" + lastloginip + '\'' +
                ", lastlogintime=" + lastlogintime +
                ", email='" + email + '\'' +
                ", realname='" + realname + '\'' +
                ", status=" + status +
                ", scope=" + scope +
                '}';
    }
}
