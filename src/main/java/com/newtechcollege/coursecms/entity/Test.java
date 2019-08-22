package com.newtechcollege.coursecms.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.newtechcollege.coursecms.annotation.validate.Phone;

/**
 * @author hy
 * @create 2019-08-02 09:31
 **/

public class Test
 {

    private String phone;

    @NotEmpty(message = "name不能为空")
    private String name;

    @NotNull(message = "age不能为null")
    private Integer age;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}