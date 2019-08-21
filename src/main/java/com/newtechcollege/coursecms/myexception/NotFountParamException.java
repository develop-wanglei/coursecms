package com.newtechcollege.coursecms.myexception;

import com.newtechcollege.coursecms.util.*;

public class NotFountParamException extends MyException {

    public NotFountParamException(){
        super(403,"参数缺失",Code.ERRORCODE_2);
    }
    public NotFountParamException(String msg){
        super(msg);
    }
}
