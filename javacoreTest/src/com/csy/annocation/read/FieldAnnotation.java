package com.csy.annocation.read;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年01月28日 下午21:29
 *
 * @author csypc
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldAnnotation {
    String filedName();
    int length();
    boolean isNull();
}
