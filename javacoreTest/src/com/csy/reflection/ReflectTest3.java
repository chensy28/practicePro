package com.csy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：根据反射机制动态操作类中的信息
 * 创建时间：2016年02月19日 下午21:57
 *
 * @author csypc
 * @version 1.0
 */
public class ReflectTest3 {
    public static void main(String[] args) {
        try{
            Class clazz = Class.forName("com.csy.reflection.Demo");
            Demo demo = (Demo)clazz.newInstance();//调用无参数的构造函数，进行实例化对象
            System.out.println(demo.getId()+":"+demo.getName()+":"+demo.getPwd());

            //调用带参数的构造函数，然后通过构造器实例化对象
            Constructor constructor = clazz.getConstructor(String.class,String.class,String.class);
            Demo demo1 = (Demo)constructor.newInstance("1","张三","123");
            System.out.println(demo1.getId()+":"+demo1.getName()+":"+demo1.getPwd());

            //通过反射API调用普通方法
            Demo demo2 = (Demo)clazz.newInstance();
            //对象直接调用
            demo2.setName("aaa");
            System.out.println(demo2.getName());

            //使用反射机制调用
            Constructor constructor2 = clazz.getConstructor(String.class,String.class,String.class);
            Demo demo3 = (Demo)constructor2.newInstance("2","李四","123");
            Method method = clazz.getDeclaredMethod("setName", String.class);//因为方法名、参数都是变量，是可变的
            method.invoke(demo3,"wangwssu");
            System.out.println(demo3.getName());

            //通过反射API操作属性
            Demo demo4 = (Demo)clazz.newInstance();
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);//设置可访问后，就不需要做安全检查了
            field.set(demo4,"ssfffss");
            System.out.println(demo4.getName());


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
