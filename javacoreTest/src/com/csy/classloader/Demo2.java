package com.csy.classloader;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��04�� ����00:23
 *
 * @author csypc
 * @version 1.0
 */
public class Demo2 {
    public static void main(String[] args) {
        //AppClassLoader ϵͳ�������
        System.out.println(ClassLoader.getSystemClassLoader());
        //ExtClassLoader ��չ�������
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        //���������������ԭ������ʵ�ֵģ������̳�ClassLoader
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        //˫��ί�ɻ��ƣ����ӵ�����ص�����ʱ�����������Ƚ���������ί�ɸ���������������׷˷��ֱ��үү��߱��ġ�
        //������������ܼ��أ����ɸ�������ִ�У��������ɵ�ǰ���������ء�
        //˫��ί�ɻ���Ϊ�˱�֤java���Ŀ�İ�ȫ
        System.out.println("------------------------");
        String str = "yyysss";
        System.out.println(str.getClass().getClassLoader());
        System.out.println(str);
    }
}
