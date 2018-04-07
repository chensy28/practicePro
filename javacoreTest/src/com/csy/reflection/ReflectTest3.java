package com.csy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * �����������ݷ�����ƶ�̬�������е���Ϣ
 * ����ʱ�䣺2016��02��19�� ����21:57
 *
 * @author csypc
 * @version 1.0
 */
public class ReflectTest3 {
    public static void main(String[] args) {
        try{
            Class clazz = Class.forName("com.csy.reflection.Demo");
            Demo demo = (Demo)clazz.newInstance();//�����޲����Ĺ��캯��������ʵ��������
            System.out.println(demo.getId()+":"+demo.getName()+":"+demo.getPwd());

            //���ô������Ĺ��캯����Ȼ��ͨ��������ʵ��������
            Constructor constructor = clazz.getConstructor(String.class,String.class,String.class);
            Demo demo1 = (Demo)constructor.newInstance("1","����","123");
            System.out.println(demo1.getId()+":"+demo1.getName()+":"+demo1.getPwd());

            //ͨ������API������ͨ����
            Demo demo2 = (Demo)clazz.newInstance();
            //����ֱ�ӵ���
            demo2.setName("aaa");
            System.out.println(demo2.getName());

            //ʹ�÷�����Ƶ���
            Constructor constructor2 = clazz.getConstructor(String.class,String.class,String.class);
            Demo demo3 = (Demo)constructor2.newInstance("2","����","123");
            Method method = clazz.getDeclaredMethod("setName", String.class);//��Ϊ���������������Ǳ������ǿɱ��
            method.invoke(demo3,"wangwssu");
            System.out.println(demo3.getName());

            //ͨ������API��������
            Demo demo4 = (Demo)clazz.newInstance();
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);//���ÿɷ��ʺ󣬾Ͳ���Ҫ����ȫ�����
            field.set(demo4,"ssfffss");
            System.out.println(demo4.getName());


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
