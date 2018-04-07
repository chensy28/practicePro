package com.csy;

import java.io.UnsupportedEncodingException;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��24�� ����22:40
 *
 * @author csypc
 * @version 1.0
 */
public class CharEncordingTest2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = new String("�й���");
        //System.out.println(str);
        String newStr = new String(str.getBytes("utf-8"),"iso-8859-1");
        String newStr2 = new String(str.getBytes("iso-8859-1"),"utf-8");
        String newStr3 = new String(str.getBytes("gbk"),"iso-8859-1");
        String newStr4 = new String(str.getBytes("iso-8859-1"),"gbk");
        String newStr5 = new String(str.getBytes("gbk"),"utf-8");
        String newStr6 = new String(str.getBytes("utf-8"),"gbk");
        System.out.println(newStr);
        System.out.println(newStr2);
        System.out.println(newStr3);
        System.out.println(newStr4);
        System.out.println(newStr5);
        System.out.println(newStr6);


    }
}
