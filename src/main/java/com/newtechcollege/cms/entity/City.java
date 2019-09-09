package com.newtechcollege.cms.entity;

import java.util.List;

/**
 * City 城市类
 */
public class City {
	private int id;
	private String name;
	private String status;
	private String create_time;
	private String update_time;
	private List<School> school;
	private List<Col> col;

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

	/**
	 * @return the col
	 */
	public List<Col> getCol() {
		return col;
	}
	/**
	 * @param col the col to set
	 */
	public void setCol(List<Col> col) {
		this.col = col;
	}

	/**
	 * @return the school
	 */
	public List<School> getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(List<School> school) {
		this.school = school;
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
	 * @param city_name the city_name to set
	 */
	public void setName(String city_name) {
		this.name = name;
	}
	/**
	 * @return the city_name
	 */
	public String getName() {
		return name;
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