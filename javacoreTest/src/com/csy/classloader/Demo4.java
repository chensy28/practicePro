package com.csy.classloader;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��05�� ����07:40
 *
 * @author csypc
 * @version 1.0
 */
public class Demo4 {
    public static void main(String[] args) throws Exception{
        int a = 3;
       /* System.out.println(Integer.toHexString(a | 0xff));  //���л����㣬����16���Ʊ�ʾ���ַ���
        System.out.println(Integer.toBinaryString(a & 0xff));//����������
        System.out.println(Integer.toBinaryString(a ^ 0xff));//����ȡ������*/

        //���ܺ����java.lang.ClassFormatError: Incompatible magic value����Ϊclass�ṹ�ı��ˣ�������Ҫ����
        //����ذ�ԭ���Ĺ������class,class���ܺ��ʽ���ˣ����Լ��ز���
      /*  FileSytemLoader loader = new FileSytemLoader("H:/myjavatest");
        Class<?> c = loader.findClass("com.csy.temp.HelloWorld");
        System.out.println(c.hashCode());*/

        DncryptClassLoader loader = new DncryptClassLoader("H:/myjavatest");
        Class<?> c = loader.findClass("com.csy.temp.HelloWorld");
        System.out.println(c.hashCode());

    }
}
