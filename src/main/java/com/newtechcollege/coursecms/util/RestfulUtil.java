package com.newtechcollege.coursecms.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * 定义客户端成功返回结果
 */
public  class  RestfulUtil {

    /**
	 * 成功默认返回 2xx
	 */
	private Integer code = 200;
	/**
	 * 返回数据或信息
	 */
    private String data = "success ok";
    

    public static String json(Object obj){
       
        RestfulUtil restfulUtil = new RestfulUtil();

        JSONObject json = new JSONObject();
        json.put("code",restfulUtil.code);
        if(obj == null){
            obj = restfulUtil.data;
        }
        json.put("data",JSON.toJSON(obj));
        return json.toString();
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

}
