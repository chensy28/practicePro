package com.csy.annocation.read;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.csy.annocation.read.Student;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年01月28日 下午21:30
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


            //获取指定类的注解
            TableAnnotation table = (TableAnnotation)clazz.getAnnotation(TableAnnotation.class);
            System.out.println(table.tableName());

            //获取指定字段的注解
            Field field = clazz.getDeclaredField("age");
            FieldAnnotation anno = field.getAnnotation(FieldAnnotation.class);
            System.out.println(anno.filedName()+":"+anno.isNull()+":"+anno.length());

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
