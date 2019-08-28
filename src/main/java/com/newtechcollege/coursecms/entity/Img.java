package com.newtechcollege.coursecms.entity;

/**
 * Img 图片类
 */
public class Img {
	private int id;
	private String imgsrc;
	private String img_title;
	private Integer aid;
	private Integer sid;
	private String status;
	private School school;
	private Col col;

	/**
	 * @return the col
	 */
	public Col getCol() {
		return col;
	}
	/**
	 * @param col the col to set
	 */
	public void setCol(Col col) {
		this.col = col;
	}
	/**
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
	}
	/**
	 * @return the sid
	 */
	public Integer getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the imgsrc
	 */
	public String getImgsrc() {
		return imgsrc;
	}
	/**
	 * @param imgsrc the imgsrc to set
	 */
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	/**
	 * @return the img_title
	 */
	public String getImg_title() {
		return img_title;
	}
	/**
	 * @param img_title the img_title to set
	 */
	public void setImg_title(String img_title) {
		this.img_title = img_title;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}