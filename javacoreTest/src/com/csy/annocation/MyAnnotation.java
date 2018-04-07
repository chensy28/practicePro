package com.csy.annocation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 项目名称：springbasic
 * 类名称：MyAnnotation
 * 类描述：自定义注解
 * 创建时间：2016年01月27日 下午23:13
 *
 * @author csypc
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)  //注释的保留策略
@Target(value={ElementType.METHOD,ElementType.TYPE,ElementType.FIELD,
        ElementType.LOCAL_VARIABLE,ElementType.PARAMETER,ElementType.PACKAGE})
public @interface MyAnnotation {
    String value() default "";
    String[] arr() default {"ad"};
}
