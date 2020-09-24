package com.softdev.system.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 编写一个注解，用于需要验证重复提交的方法上
 * @ClassName: SubmitToken
 * @Author: liangbl
 * @Date: 2020/6/29 13:24
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SubmitToken {
    boolean value() default true;
}
