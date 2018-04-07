package com.csy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������ͨ��������ƻ�ȡ�ࡢ���ԡ����������췽������Ϣ
 * ����ʱ�䣺2016��02��07�� ����15:15
 *
 * @author csypc
 * @version 1.0
 */
public class ReflectTest2 {
    public static void main(String[] args) {
        try {
            //��ȡ�������
            Class clazz = Class.forName("com.csy.reflection.Demo");
            System.out.println(clazz.getName());//��ȡ����+����
            System.out.println(clazz.getSimpleName());//��ȡ����

            //��ȡ���Ե���Ϣ
            Field[] fields = clazz.getFields();   //��ȡ���пɷ��ʹ����ֶ�
            System.out.println(fields.length);

            //��ȡָ�����ƵĹ����ֶ�
            Field field = clazz.getField("pwd");
            System.out.println(field.getName());

            //��ȡ�����������ֶΣ�����private��public�ȣ�
            Field[] fields2 = clazz.getDeclaredFields();
            System.out.println(fields2.length);

            //��ȡָ�����Ƶ��ֶ�
            Field field2 = clazz.getDeclaredField("name");
            System.out.println(field2.getName());

            //��ȡ�����ķ���(�����Ӹ���̳еĹ�������)
            Method[] methods = clazz.getMethods();
            for(Method method : methods) {
                System.out.println("���еĹ���������" + method.getName());
            }

            //��ȡָ�������Ĺ�������
            Method method = clazz.getMethod("setId", String.class);
            System.out.println("ָ���Ĺ���������"+method.getName());

            //��ȡ���������ķ������������Ӹ���̳еķ�����
            Method [] methods1 = clazz.getDeclaredMethods();
            for(Method method2 : methods1) {
                System.out.println("���������ķ�����" + method2.getName());
            }

            //��ȡָ�������ķ���
            Method method3 = clazz.getDeclaredMethod("show", null);
            System.out.println("ָ���ķ�����"+method3.getName());

            //��ȡ���캯��(�����Ĺ��캯��)
            Constructor[] constructors = clazz.getConstructors();
            System.out.println("���캯����"+constructors.length);

            //��ȡָ���Ĺ��캯��(�����Ĺ��캯��)
            Constructor constructor = clazz.getConstructor(String.class,String.class,String.class);
            System.out.println(constructor.getName());

            //��ȡ���캯��
            Constructor[] constructors2 = clazz.getDeclaredConstructors();
            System.out.println("���й��캯����"+constructors2.length);

            //��ȡָ���Ĺ��캯��
            Constructor constructor2 = clazz.getDeclaredConstructor(String.class, String.class, String.class);
            System.out.println(constructor2.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


