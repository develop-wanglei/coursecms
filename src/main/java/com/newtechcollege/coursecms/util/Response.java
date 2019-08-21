/**
 * 
 */
package com.newtechcollege.coursecms.util;


import java.io.Serializable;

/**
 * 响应参数实体
 * 
 */
public class Response<T> implements Serializable{

	private static final long serialVersionUID = 4250719891313555820L;

	/**
	 * //HTTP 状态码 404 , 200
	 */
	private Integer code = 400;
	/**
	 * 错误具体信息
	 */
	private String msg = "未知错误";
	/**
	 * 自定义错误码
	 */
	private Integer errcode = 999;


	public Response(Integer code,String msg,Integer errcode){
		this.code = code;
		this.msg = msg ;
		this.errcode = errcode;
	}
	public Response(){
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the errcode
	 */
	public Integer getErrcode() {
		return errcode;
	}
	/**
	 * @param errcode the errcode to set
	 */
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

}
