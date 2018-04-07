package com.csy.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�demo8
 * ��������BiMap ����ֵ�������ظ�
 * ����ʱ�䣺2016��01��21�� ����08:10
 *
 * @author csypc
 * @version 1.0
 */
public class demo8 {
    public static void main(String[] args) {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","a"); //��ǿ�����룬�ظ���ֵ�ᱻ����
        biMap.put("1","b");
        biMap.put("2","a");

        /*biMap.forcePut("1","a"); //ǿ������(���ǳ����ظ���ֵ���ᱨ��)
        biMap.forcePut("1","b");
        biMap.forcePut("2","c");
*/

        //����ֵ��ת
        BiMap reverse = biMap.inverse();

        //�ڷ�ת
        BiMap again = reverse.inverse();
        again.clear(); //�˴���again��reverse��biMap����ͬһ�����ã��������һ����������Ҳ�������
        System.out.println(biMap.entrySet());
        System.out.println(biMap.size());
    }
}
