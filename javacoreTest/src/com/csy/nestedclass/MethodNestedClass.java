package com.csy.nestedclass;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * �������������ڲ���ʹ��
 * ����ʱ�䣺2016��03��06�� ����10:47
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

    //�����ڲ���
    public void methodShow(int c){
        int d =1;

        int var = 22;

        //�����ڲ������ú;ֲ��������ƣ����Բ�����private��protected������
        /*private class A{   error
        }*/

        //��Ҫ����������ʹ��
        /*A inner = new A();  errror
        inner.show();*/
        class A {
            private int e = 1;
            //�����ڲ���ֻ�ܰ����Ǿ�̬��Ա
            //private static int f = 1; error

            public void show(){
                System.out.println("inner:"+var);//�˴������ڲ�����ʷ����ľֲ�����û�м�finalҲ�ɷ��ʣ�jdk8���ԣ�
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
