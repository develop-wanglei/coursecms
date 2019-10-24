package com.newtechcollege.cms.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BannerItem {

    private Integer id;
    @NotNull(message = "img_id 字段缺失或为空")
    private Integer img_id;
    @NotNull(message = "banner_id 字段缺失或为空")
    private Integer banner_id;
    @NotEmpty(message = "key_word 字段缺失或为空")
    private String key_word;
    private Integer type;
    private String create_time;
    private String update_time;
    private String delete_time;
    private Integer status;
    private Image image;


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImg_id() {
        return img_id;
    }

    public void setImg_id(Integer img_id) {
        this.img_id = img_id;
    }

    public Integer getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(Integer banner_id) {
        this.banner_id = banner_id;
    }

    public String getKey_word() {
        return key_word;
    }

    public void setKey_word(String key_word) {
        this.key_word = key_word;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    public String getDelete_time() {
        return delete_time;
    }

    public void setDelete_time(String delete_time) {
        this.delete_time = delete_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
