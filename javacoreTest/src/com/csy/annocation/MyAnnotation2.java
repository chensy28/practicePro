package com.csy.annocation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��01��27�� ����23:59
 *
 * @author csypc
 * @version 1.0
 */
@Target(value={ElementType.ANNOTATION_TYPE,ElementType.LOCAL_VARIABLE})
public @interface MyAnnotation2 {
}
