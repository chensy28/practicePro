package com.csy.classloader;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��04�� ����21:04
 *
 * @author csypc
 * @version 1.0
 */
public class Demo3 {
    public static void main(String[] args) throws Exception{
        //ͬһ���౻��ͬ�ļ��������ص��࣬�ǲ�һ������
        FileSytemLoader loader = new FileSytemLoader("H:/myjavatest");
        FileSytemLoader loader2 = new FileSytemLoader("H:/myjavatest");
        Class<?> c = loader.findClass("com.csy.HelloWorld");
        Class<?> c2 = loader2.findClass("com.csy.HelloWorld");  //�˴�ͬһ������������ͬһ���࣬����(jdk8)
                                                               // attempted  duplicate class definition for name: "HelloWorld"
        //Class<?> c3 = loader2.findClass("com.csy.HelloWorld");
        System.out.println(c.hashCode());
        System.out.println(c2.hashCode());
       // System.out.println(c3.hashCode());

    }
}
