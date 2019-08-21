package com.newtechcollege.coursecms.myexception;

import com.newtechcollege.coursecms.util.*;

public class ParameterException extends MyException {

    public static final long serialVersionUID = 536871008;

    public ParameterException(){
        super(400,"参数错误",Code.ERRORCODE_1);
    }
    public ParameterException(String msg){
        super(msg);
    }
}
