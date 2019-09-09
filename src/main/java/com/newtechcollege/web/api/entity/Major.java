package com.newtechcollege.web.api.entity;

import javax.validation.constraints.NotEmpty;

public class Major {

    private  Integer majorid;
    @NotEmpty(message = "majorname 字段缺失或为空")
    private  String majorname;
    @NotEmpty(message = "majorimgsrc 字段缺失或为空")
    private  String majorimgsrc;
    private  Integer majorstatus;

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public String getMajorimgsrc() {
        return majorimgsrc;
    }

    public void setMajorimgsrc(String majorimgsrc) {
        this.majorimgsrc = majorimgsrc;
    }

    public Integer getMajorstatus() {
        return majorstatus;
    }

    public void setMajorstatus(Integer majorstatus) {
        this.majorstatus = majorstatus;
    }
}
