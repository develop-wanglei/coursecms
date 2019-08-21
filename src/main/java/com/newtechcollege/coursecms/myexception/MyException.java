package com.newtechcollege.coursecms.myexception;

import com.newtechcollege.coursecms.util.*;

public class MyException extends RuntimeException {

    public static final long serialVersionUID = 536871008;

    private int code = 400;

    private String msg ="基础错误";
   
    private int errcode = Code.ERRORCODE_9;

    public MyException(){}

    public MyException(int code,String msg,int errcode){
        this.msg = msg ;
        this.code = code;
        this.errcode = errcode;
    }
    public MyException(String msg,int errcode){
        this.msg = msg ;
        this.errcode = errcode;
    }
    public MyException(String msg){
        this.msg = msg ;
    }

  

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    /**
     * @return the errcode
     */
    public int getErrcode() {
        return errcode;
    }
    /**
     * @param errcode the errcode to set
     */
    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
