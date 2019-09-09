package com.newtechcollege.web.api.myexception;

import com.newtechcollege.web.api.util.*;
import com.newtechcollege.web.api.util.Code;

public class ParameterException extends MyException {

    public static final long serialVersionUID = 536871008;

    public ParameterException(){
        super(400,"参数错误", Code.ERRORCODE_1);
    }
    public ParameterException(String msg){
        super(msg);
    }
}
