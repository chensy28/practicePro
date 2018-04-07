package com.csy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：通过反射机制获取类、属性、方法、构造方法的信息
 * 创建时间：2016年02月07日 下午15:15
 *
 * @author csypc
 * @version 1.0
 */
public class ReflectTest2 {
    public static void main(String[] args) {
        try {
            //获取类的名称
            Class clazz = Class.forName("com.csy.reflection.Demo");
            System.out.println(clazz.getName());//获取包名+类名
            System.out.println(clazz.getSimpleName());//获取类名

            //获取属性的信息
            Field[] fields = clazz.getFields();   //获取所有可访问公共字段
            System.out.println(fields.length);

            //获取指定名称的公共字段
            Field field = clazz.getField("pwd");
            System.out.println(field.getName());

            //获取声明的所有字段（包括private、public等）
            Field[] fields2 = clazz.getDeclaredFields();
            System.out.println(fields2.length);

            //获取指定名称的字段
            Field field2 = clazz.getDeclaredField("name");
            System.out.println(field2.getName());

            //获取公共的方法(包括从父类继承的公共方法)
            Method[] methods = clazz.getMethods();
            for(Method method : methods) {
                System.out.println("所有的公共方法：" + method.getName());
            }

            //获取指定参数的公共方法
            Method method = clazz.getMethod("setId", String.class);
            System.out.println("指定的公共方法："+method.getName());

            //获取所有声明的方法（不包括从父类继承的方法）
            Method [] methods1 = clazz.getDeclaredMethods();
            for(Method method2 : methods1) {
                System.out.println("所有声明的方法：" + method2.getName());
            }

            //获取指定参数的方法
            Method method3 = clazz.getDeclaredMethod("show", null);
            System.out.println("指定的方法："+method3.getName());

            //获取构造函数(公共的构造函数)
            Constructor[] constructors = clazz.getConstructors();
            System.out.println("构造函数："+constructors.length);

            //获取指定的构造函数(公共的构造函数)
            Constructor constructor = clazz.getConstructor(String.class,String.class,String.class);
            System.out.println(constructor.getName());

            //获取构造函数
            Constructor[] constructors2 = clazz.getDeclaredConstructors();
            System.out.println("所有构造函数："+constructors2.length);

            //获取指定的构造函数
            Constructor constructor2 = clazz.getDeclaredConstructor(String.class, String.class, String.class);
            System.out.println(constructor2.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


