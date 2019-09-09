package com.newtechcollege.web.api.myexception;

import com.newtechcollege.web.api.util.*;
import com.newtechcollege.web.api.util.Code;

public class NotFountParamException extends MyException {

    public NotFountParamException(){
        super(403,"参数缺失", Code.ERRORCODE_2);
    }
    public NotFountParamException(String msg){
        super(msg);
    }
}
