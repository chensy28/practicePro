package com.csy.ref;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/16.
 * Time:22:55.
 */
public class RefTest {
    public static void main(String []args){
        //�ַ��������ǹ���ģ����ܱ�����
        //String str = "hello world";

        //�ַ����ܱ�����
        String str = new String("hello world");
        //�����ù������
        WeakReference<String> ref = new WeakReference<>(str);
        System.out.println("gc����ǰ��" + ref.get());
        //�Ͽ����ú󣬱�������������
        str = null;
        //��������������
        System.gc();
        //���д��ڹ�����ֹ״̬�����ж������ֹ������
        System.runFinalization();
        System.out.println("gc���к�" + ref.get());
    }
}
