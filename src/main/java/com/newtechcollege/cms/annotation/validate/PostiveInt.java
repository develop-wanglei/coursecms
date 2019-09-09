package com.newtechcollege.cms.annotation.validate;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.newtechcollege.cms.annotation.validate.Impl.PostiveIntValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PostiveIntValidator.class)
public @interface PostiveInt {

    boolean required() default true;
    String message() default "参数不合法,id 必须是正整数";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
