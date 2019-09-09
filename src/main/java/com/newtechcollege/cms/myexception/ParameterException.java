package com.newtechcollege.cms.myexception;

import com.newtechcollege.cms.util.*;

public class ParameterException extends MyException {

    public static final long serialVersionUID = 536871008;

    public ParameterException(){
        super(400,"参数错误",Code.ERRORCODE_1);
    }
    public ParameterException(String msg){
        super(msg);
    }
}
