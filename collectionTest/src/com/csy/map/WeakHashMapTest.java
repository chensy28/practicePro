package com.csy.map;

import java.util.WeakHashMap;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/17.
 * Time:8:32.
 */
public class WeakHashMapTest {
    public static void main(String []args) {
        WeakHashMap<String,String> map = new WeakHashMap<>();
        //��Ϊ�ַ�������ʱ���ܱ�����
        map.put("a","aa");
        map.put("b","bb");
        //gc����ʱ�ɱ�����
        map.put(new String("c"),"cc");
        map.put(new String("d"),"dd");

        System.out.println(map.size());
        //����gc
        System.gc();
        System.runFinalization();
        System.out.println(map.size());
    }
}
