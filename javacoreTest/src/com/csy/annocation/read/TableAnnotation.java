package com.csy.annocation.read;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��01��28�� ����21:28
 *
 * @author csypc
 * @version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableAnnotation {
    String tableName();
}
