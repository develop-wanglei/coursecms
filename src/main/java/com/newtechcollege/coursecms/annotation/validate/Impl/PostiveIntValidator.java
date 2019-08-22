package com.newtechcollege.coursecms.annotation.validate.Impl;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.newtechcollege.coursecms.annotation.validate.PostiveInt;


public class PostiveIntValidator implements ConstraintValidator<PostiveInt, Integer> {

    private boolean required = false;
	// 定义的正整数验证正则表达式
    private Pattern pattern = Pattern.compile("^[1-9]\\d*$");

    @Override
    public void initialize(PostiveInt constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        String id = s + "";
        if(required) {
            return pattern.matcher(id).matches();
        }else {
            if("".equals(id) && id == null) {
                return false;
            }else{
                return pattern.matcher(id).matches();
            }
        }
    }
}
