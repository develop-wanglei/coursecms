package com.newtechcollege.coursecms.entity;

/**
 * Img 图片类
 */
public class Img {
	private int id;
	private String imgsrc;
	private String img_title;
	private String aid;
	private String status;
	
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
	 * @return the aid
	 */
	public String getAid() {
		return aid;
	}
	/**
	 * @param aid the aid to set
	 */
	public void setAid(String aid) {
		this.aid = aid;
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