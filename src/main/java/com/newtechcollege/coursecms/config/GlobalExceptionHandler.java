package com.newtechcollege.coursecms.config;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

import com.newtechcollege.coursecms.dao.ErrMapper;
import com.newtechcollege.coursecms.entity.ErrException;
import com.newtechcollege.coursecms.myexception.MyException;
import com.newtechcollege.coursecms.util.Code;
import com.newtechcollege.coursecms.util.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
// import org.springframework.validation.BindException;
// import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

     @Resource
     private ErrMapper errMapper;  

     private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 自定义对象参数错误异常返回
     */
     @ExceptionHandler(value = BindException.class)
     @ResponseBody
     public Response<String> bindExceptionErrorHandler(BindException ex) throws Exception {
            Response<String> r = new Response<>();
            r.setCode(400);
            r.setMsg(ex.getFieldError().getDefaultMessage());
            r.setErrcode(Code.ERRORCODE_0);
           return r;
     }
     /**
     * 自定义单个参数参数错误异常返回
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public Response<String> consExceptionErrorHandler(ConstraintViolationException ex) throws Exception {
           Response<String> r = new Response<>();
           r.setCode(400);
           r.setMsg(ex.getLocalizedMessage());
           r.setErrcode(Code.ERRORCODE_0);
          return r;
    }

     /**
     * 自定义全局异常返回
     */
     @ExceptionHandler(value = Exception.class)
     @ResponseBody
     public Response<String> ExceptionErrorHandler(Exception ex) throws Exception {
            Response<String> r = new Response<>();
            r.setCode(500);
           
            //存储到数据库
            ErrException err =  new ErrException();
            err.setErrmsg(ex.getMessage());
            errMapper.insert(err);   

            //返回给客户端
            r.setMsg("服务器错误,请稍后再试");   
            r.setErrcode(Code.ERRORCODE_0);
        
           return r;
     }

     //自定义异常返回
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Response<String> myExceptionErrorHandler(MyException ex) throws Exception {
        // logger.error("myExceptionErrorHandler info:{}",ex.getMessage());
        Response<String> r = new Response<>();
        r.setCode(ex.getCode());
        r.setMsg(ex.getMsg());
        r.setErrcode(ex.getErrcode());;
        return r;
    }




}
