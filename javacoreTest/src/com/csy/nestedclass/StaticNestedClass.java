package com.csy.nestedclass;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ����������̬�ڲ���ʹ��
 * ����ʱ�䣺2016��03��06�� ����09:20
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

        //��̬�ڲ�����԰�����̬��Ա��Ҳ�ܰ����Ǿ�̬��Ա
        private int c = 1;
        private static int d = 2;

        public void show(){
            //��̬�ڲ���,�ܷ����ⲿ�ڵľ�̬��Ա�������ܷ����ⲿ�ڵķǾ�̬��Ա
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
        //�����ڲ���ķ�ʽ
        StaticNestedClass.A a = new StaticNestedClass.A();
        //A a = new A();
        a.show();
    }
}
