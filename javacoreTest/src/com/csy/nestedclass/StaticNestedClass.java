package com.csy.nestedclass;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：静态内部类使用
 * 创建时间：2016年03月06日 下午09:20
 *
 * @author csypc
 * @version 1.0
 */
public class StaticNestedClass {
    private int a = 1;
    private static int b = 2;

    public void out1(){
        System.out.println("out show");
    }

    public static void out2(){
        System.out.println("out show2");
    }


    private static class A{

        //静态内部类可以包含静态成员、也能包含非静态成员
        private int c = 1;
        private static int d = 2;

        public void show(){
            //静态内部类,能访问外部内的静态成员，但不能访问外部内的非静态成员
  //          System.out.println(a);     error
            System.out.println("nested:" + b);
            System.out.println("nested:" + c);
            System.out.println("nested:" + d);

            //out1();     error
            out2();

            A inner = new A();
            System.out.println("nested create:" + inner.c);

        }

        public static void showA(){
        }
    }

    public static void main(String[] args) {
        //创建内部类的方式
        StaticNestedClass.A a = new StaticNestedClass.A();
        //A a = new A();
        a.show();
    }
}
