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
        //键为字符串常量时不能被回收
        map.put("a","aa");
        map.put("b","bb");
        //gc运行时可被回收
        map.put(new String("c"),"cc");
        map.put(new String("d"),"dd");

        System.out.println(map.size());
        //运行gc
        System.gc();
        System.runFinalization();
        System.out.println(map.size());
    }
}
