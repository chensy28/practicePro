package com.csy.reflection;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��02��07�� ����15:15
 *
 * @author csypc
 * @version 1.0
 */
public class ReflectTest {
    public static void main(String[] args) {
        //��ȡclass�ķ�ʽ
        try {

            //ͬһ���͵Ķ�����ͬһ��class
            Class clazz = Class.forName("com.csy.reflection.Demo");          //ʹ��forName()��ȡָ�����Ƶ���
            Class clazz2 = Class.forName("com.csy.reflection.Demo");
            System.out.println(clazz.hashCode()+"\n"+clazz2.hashCode());

            //ʹ��.class��ȡClass����ȡ���Class����
            Class clazz3 = ReflectTest.class;
            System.out.println(clazz3.hashCode()+":"+clazz3.getName());

            Class clazz4 = Class.class;
            System.out.println(clazz4.hashCode()+":"+clazz4.getName());

            //��ȡ�ӿڵ�Class����
            Class clazz5 = Class.forName("com.csy.reflection.Demo2");
            System.out.println(clazz5.hashCode()+":"+clazz5.getName());

            //��ȡע���Class����
            Class clazz6 = Class.forName("com.csy.reflection.MyAnnotation");
            System.out.println(clazz6.hashCode()+":"+clazz6.getName());

            //��ȡ�������͵�Class����
            Class clazz7 = int.class;
            System.out.println(clazz7.hashCode()+":"+clazz7.getName());

            //��ͬά����������ͬ������Class������ͬ
            int []aa = new int[2];
            int []bb = new int[23];
            System.out.println(aa.getClass().hashCode());
            System.out.println(bb.getClass().hashCode());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


