package com.csy.annocation.read;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.csy.annocation.read.Student;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��01��28�� ����21:30
 *
 * @author csypc
 * @version 1.0
 */

public class ReadAnnotationTest {
    public static void main(String[] args){
        try {
            Class clazz = Class.forName("com.csy.annocation.read.Student");
            boolean isExist = clazz.isAnnotationPresent(TableAnnotation.class);
            if(isExist){
                Annotation[] arr = clazz.getAnnotations();
                for(Annotation annotation : arr){
                    System.out.println("111"+annotation);
                }
            }


            //��ȡָ�����ע��
            TableAnnotation table = (TableAnnotation)clazz.getAnnotation(TableAnnotation.class);
            System.out.println(table.tableName());

            //��ȡָ���ֶε�ע��
            Field field = clazz.getDeclaredField("age");
            FieldAnnotation anno = field.getAnnotation(FieldAnnotation.class);
            System.out.println(anno.filedName()+":"+anno.isNull()+":"+anno.length());

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
