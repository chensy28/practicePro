package com.csy.annocation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�MyAnnotation
 * ���������Զ���ע��
 * ����ʱ�䣺2016��01��27�� ����23:13
 *
 * @author csypc
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)  //ע�͵ı�������
@Target(value={ElementType.METHOD,ElementType.TYPE,ElementType.FIELD,
        ElementType.LOCAL_VARIABLE,ElementType.PARAMETER,ElementType.PACKAGE})
public @interface MyAnnotation {
    String value() default "";
    String[] arr() default {"ad"};
}
