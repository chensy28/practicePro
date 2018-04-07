package com.csy.map;

import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/16.
 * Time:15:05.
 */
public class HashTableTest {
    public static void main(String []args) {
        //Hashtable是线程安全的
        Hashtable table = new Hashtable();
        table.put("a","aa");
        table.put("b","bb");
        //table.put(null,"cc");//HashTable存值的时候不允许key、value为null
        //table.put("c",null);
        System.out.println(table.get("as"));
        /*table.compute()*/
        //将指定键的值替换掉
       /* table.replace("a","ggg");
        System.out.println(table.get("a"));*/
        //是否包含键、值
        /*System.out.println(table.containsKey("a"));
        System.out.println(table.contains("bb"));*/
//        System.out.println(table.size()+":"+table.get("a"));
    }
}
