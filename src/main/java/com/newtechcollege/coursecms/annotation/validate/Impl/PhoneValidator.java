package com.newtechcollege.coursecms.annotation.validate.Impl;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.newtechcollege.coursecms.annotation.validate.Phone;


public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private boolean required = false;
	// 定义的手机号验证正则表达式
    private Pattern pattern = Pattern.compile("1(([38]\\d)|(5[^4&&\\d])|(4[579])|(7[0135678]))\\d{8}");

    @Override
    public void initialize(Phone constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required) {
            return pattern.matcher(s).matches();
        }else {
            if("".equals(s) && s == null) {
                return false;
            }else{
                return pattern.matcher(s).matches();
            }
        }
    }
}
