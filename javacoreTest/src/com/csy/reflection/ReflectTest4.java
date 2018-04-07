package com.csy.reflection;

import java.lang.reflect.Method;

/**
 * 项目名称：springbasic
 * 类名称：反射机制执行效率
 * 类描述：
 * 创建时间：2016年02月20日 下午21:59
 *
 * @author csypc
 * @version 1.0
 */
public class ReflectTest4 {
    public static void test1(){
        Demo demo = new Demo();

        Long start = System.currentTimeMillis();
        for(int i = 1;i<=1000000000L;i++){
            demo.getName();
        }

        Long end = System.currentTimeMillis();
        System.out.println("普通方法执行的时间："+(end-start));
    }


    public static void test2() throws Exception {
        Demo demo = new Demo();

        Long start = System.currentTimeMillis();
        Method method = Demo.class.getMethod("getName",null);
        for(int i = 1;i<=1000000000L;i++){
            method.invoke(demo,null);
        }

        Long end = System.currentTimeMillis();
        System.out.println("反射执行的时间："+(end-start));
    }

    public static void test3() throws Exception {
        Demo demo = new Demo();

        Long start = System.currentTimeMillis();
        Method method = Demo.class.getMethod("getName",null);
        method.setAccessible(true);//设置为可访问的，则不进行安全检查，提高效率
        for(int i = 1;i<=1000000000L;i++){
            method.invoke(demo,null);
        }

        Long end = System.currentTimeMillis();
        System.out.println("提高效率后的反射执行的时间："+(end-start));
    }

    public static void main(String[] args) throws Exception{
        //使用反射机制可以灵活地操作方法、属性等
        //但是会降低运行效率，可以将访问设置setAccessible为可访问的，不做安全检查，可提高效率
        test1();
        test2();
        test3();
    }
}
