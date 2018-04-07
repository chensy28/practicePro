package com.csy.nestedclass;

import java.util.Date;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ����������Ա�ڲ���ʹ��
 * ����ʱ�䣺2016��03��06�� ����09:49
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


    //�����Ա���������ⲿ����
    private class Member{
        private int c = 1;
        //��Ա�ڲ����в��ܰ�����̬��Ա,��������Ϊfinal,�����Ǳ���������ȷ���ĳ������ʽ
       // private static int d = 2;       error
        private final static int d = 234;
        //private final static int d = new Date();

        public void show1(){
            //��Ա�ڲ�����Է����ⲿ�ڵ����г�Ա
            System.out.println("out : "+a);
            System.out.println("out : "+b);
            out1();
            out2();
            //this��ʾ�ڲ������
            System.out.println(this.d);

            //�ⲿ������ⲿ����+".this"
            MemberNestedClass.this.out1();

            Member member = new Member();
            System.out.println("�ڲ�����:"+member.c);

        }

//        public static void show2(){     error
//            System.out.println("out show2");
//        }


    }

    public static void main(String[] args) {
        //��Ա�ڲ������һ��Ҫ�󶨵��ⲿ��Ķ����������ⲿ��Ķ��󣬺��г�Ա�ڲ���Ķ���
        MemberNestedClass.Member member = new MemberNestedClass().new Member();
        member.show1();
    }
}
