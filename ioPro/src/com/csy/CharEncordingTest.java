package com.csy;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ���������ַ�����
 * ����ʱ�䣺2016��03��24�� ����22:17
 *
 * @author csypc
 * @version 1.0
 */
public class CharEncordingTest {
    public static void main(String[] args) throws Exception{
        // ��ȡ��ǰ��ϵͳ�����ԣ��������б������ָ�����������
        System.getProperties().list(System.out);

        String str = new String("中国的");
       /* System.out.println(str);
        String newStr = new String(str.getBytes("utf-8"),"gbk");
        System.out.println(newStr);
        String newStr2 = new String(str.getBytes("gbk"),"utf-8");
        System.out.println(newStr2);*/
        //String newStr2 = new String(str.getBytes("gbk"),"utf-8");
        String newStr = new String(str.getBytes("utf-8"),"gbk");
        System.out.println(newStr);
    }
}
