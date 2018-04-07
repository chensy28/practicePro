package com.csy.reflection;

import java.lang.reflect.Method;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ��������ִ��Ч��
 * ��������
 * ����ʱ�䣺2016��02��20�� ����21:59
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
        System.out.println("��ͨ����ִ�е�ʱ�䣺"+(end-start));
    }


    public static void test2() throws Exception {
        Demo demo = new Demo();

        Long start = System.currentTimeMillis();
        Method method = Demo.class.getMethod("getName",null);
        for(int i = 1;i<=1000000000L;i++){
            method.invoke(demo,null);
        }

        Long end = System.currentTimeMillis();
        System.out.println("����ִ�е�ʱ�䣺"+(end-start));
    }

    public static void test3() throws Exception {
        Demo demo = new Demo();

        Long start = System.currentTimeMillis();
        Method method = Demo.class.getMethod("getName",null);
        method.setAccessible(true);//����Ϊ�ɷ��ʵģ��򲻽��а�ȫ��飬���Ч��
        for(int i = 1;i<=1000000000L;i++){
            method.invoke(demo,null);
        }

        Long end = System.currentTimeMillis();
        System.out.println("���Ч�ʺ�ķ���ִ�е�ʱ�䣺"+(end-start));
    }

    public static void main(String[] args) throws Exception{
        //ʹ�÷�����ƿ������ز������������Ե�
        //���ǻή������Ч�ʣ����Խ���������setAccessibleΪ�ɷ��ʵģ�������ȫ��飬�����Ч��
        test1();
        test2();
        test3();
    }
}
