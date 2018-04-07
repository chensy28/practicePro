package com.csy.nestedclass;

import java.util.Date;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：成员内部类使用
 * 创建时间：2016年03月06日 下午09:49
 *
 * @author csypc
 * @version 1.0
 */
public class MemberNestedClass {
    private int a = 1;
    private static int b = 2;

    public void out1(){
        System.out.println("out show");
    }

    public static void out2(){
        System.out.println("out show2");
    }


    //就像成员变量存在外部类中
    private class Member{
        private int c = 1;
        //成员内部类中不能包含静态成员,除非声明为final,并且是编译器可以确定的常量表达式
       // private static int d = 2;       error
        private final static int d = 234;
        //private final static int d = new Date();

        public void show1(){
            //成员内部类可以访问外部内的所有成员
            System.out.println("out : "+a);
            System.out.println("out : "+b);
            out1();
            out2();
            //this表示内部类对象
            System.out.println(this.d);

            //外部类对象：外部类名+".this"
            MemberNestedClass.this.out1();

            Member member = new Member();
            System.out.println("内部创建:"+member.c);

        }

//        public static void show2(){     error
//            System.out.println("out show2");
//        }


    }

    public static void main(String[] args) {
        //成员内部类对象一定要绑定到外部类的对象，所以有外部类的对象，后有成员内部类的对象
        MemberNestedClass.Member member = new MemberNestedClass().new Member();
        member.show1();
    }
}
