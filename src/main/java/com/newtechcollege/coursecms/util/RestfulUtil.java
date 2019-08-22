package com.newtechcollege.coursecms.util;

import com.alibaba.fastjson.JSONObject;


public  class  RestfulUtil {
    public static String success(Object obj){
        JSONObject json = new JSONObject();
            json.put("code",200);
            json.put("data",obj);
        return json.toString();
    }
//    public static String error(Integer code,String msg){
//        JSONObject json = new JSONObject();
//        json.put("code",code);
//        json.put("msg",msg);
//        return json.toString();
//    }
}
