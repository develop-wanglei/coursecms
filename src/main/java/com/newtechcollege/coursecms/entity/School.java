package com.newtechcollege.coursecms.entity;

/**
 * School 实训基地类
 */
public class School {
	private int id;
	private String name;
	private String imgsrc;
	private String cid;
	private String imgId;
	private String status;
	
	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
	 * @return the imgsrc
	 */
	public String getImgId() {
		return imgsrc;
	}
	/**
	 * @param imgsrc the imgsrc to set
	 */
	public void setImgId(String imgsrc) {
		this.imgsrc = imgsrc;
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