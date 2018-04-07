package com.csy.nestedclass;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：方法内部类使用
 * 创建时间：2016年03月06日 下午10:47
 *
 * @author csypc
 * @version 1.0
 */
public class MethodNestedClass {

    private int a = 1;
    private static int b = 2;

    public void out1(){
        System.out.println("out show");
    }

    public static void out2(){
        System.out.println("out show2");
    }

    //方法内部类
    public void methodShow(int c){
        int d =1;

        int var = 22;

        //方法内部类作用和局部变量类似，所以不能用private、protected等修饰
        /*private class A{   error
        }*/

        //需要先声明、后使用
        /*A inner = new A();  errror
        inner.show();*/
        class A {
            private int e = 1;
            //方法内部类只能包含非静态成员
            //private static int f = 1; error

            public void show(){
                System.out.println("inner:"+var);//此处方法内部类访问方法的局部变量没有加final也可访问，jdk8特性？
                System.out.println("inner:"+d);
                System.out.println("inner:"+c);

            }
        }

        A inner = new A();
        inner.show();

    }



    public static void main(String[] args) {
        MethodNestedClass clazz = new MethodNestedClass();
        clazz.methodShow(234);
    }
}
