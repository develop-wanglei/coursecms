package com.newtechcollege.cms.config;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

import com.newtechcollege.cms.dao.ErrMapper;
import com.newtechcollege.cms.entity.ErrException;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.util.Code;
import com.newtechcollege.cms.util.Response;
import java.lang.*;

import io.jsonwebtoken.MalformedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

     @Resource
     private ErrMapper errMapper;  

     private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


      /**
     * 全局异常处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response<String> ExceptionErrorHandler(Exception ex) throws Exception {
           Response<String> r = new Response<>();
           r.setCode(500);
           //获取异常类型
        String class_ex = ex.getClass().toString();
        String str_ex = "";
        if(ex.getClass() != null){
            String exe[] = class_ex.split("\\.");
            str_ex = exe[exe.length - 1];
        }
           if("MethodArgumentTypeMismatchException".equals(str_ex)){//参数类型错误
                r.setMsg("参数类型错误");
                r.setErrcode(Code.ERRORCODE_0);
           }else if("MalformedJwtException".equals(str_ex)){
               r.setMsg("token过期或无效");
               r.setErrcode(Code.ERRORCODE_0);
           }else{
                //存储到数据库
                ErrException err =  new ErrException();
                if(ex.getMessage() != null){
                    err.setErrmsg(ex.getMessage());
                    errMapper.insert(err);
                    r.setMsg(ex.getMessage());
                }
                //返回给客户端

//                r.setMsg("服务器错误,请稍后再试");
                r.setErrcode(Code.ERRORCODE_0);
           }

          return r;
    }

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
     * token
     */
    @ExceptionHandler(value = MalformedJwtException.class)
    @ResponseBody
    public Response<String> malExceptionErrorHandler(MalformedJwtException ex) throws Exception {
        Response<String> r = new Response<>();
        r.setCode(400);
        r.setMsg("token过期或失效");
        r.setErrcode(Code.ERRORCODE_0);
        return r;
    }
    
     /**
     * 自定义单个参数验证错误异常返回
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public Response<String> consExceptionErrorHandler(ConstraintViolationException ex) throws Exception {
           Response<String> r = new Response<>();
           r.setCode(400);
           //隐藏 信息中的 方法,避免被恶意攻击
           String msg = ex.getMessage().split(":")[1];
           r.setMsg(msg);
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
        r.setErrcode(ex.getErrcode());
        return r;
    }




}
