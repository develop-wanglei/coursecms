package com.newtechcollege.web.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BadRequestExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(BadRequestExceptionHandler.class);
    /**
     *  校验错误拦截处理
     *
     * @param exception 错误信息集合
     * @return 错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String validationBodyException(MethodArgumentNotValidException exception){
        String e="";
        BindingResult result = exception.getBindingResult();
        if (result.hasErrors()) {

//            List<ObjectError> errors = result.getAllErrors();
//
//            errors.forEach(p ->{
//
//                FieldError fieldError = (FieldError) p;
//                logger.error("Data check failure : object{"+fieldError.getObjectName()+"},field{"+fieldError.getField()+
//                        "},errorMessage{"+fieldError.getDefaultMessage()+"}");
//
//            });
            e=result.getFieldError().getDefaultMessage();

        }
        return "";
    }
}
