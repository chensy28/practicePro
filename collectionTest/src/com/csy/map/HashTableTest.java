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
        //Hashtable���̰߳�ȫ��
        Hashtable table = new Hashtable();
        table.put("a","aa");
        table.put("b","bb");
        //table.put(null,"cc");//HashTable��ֵ��ʱ������key��valueΪnull
        //table.put("c",null);
        System.out.println(table.get("as"));
        /*table.compute()*/
        //��ָ������ֵ�滻��
       /* table.replace("a","ggg");
        System.out.println(table.get("a"));*/
        //�Ƿ��������ֵ
        /*System.out.println(table.containsKey("a"));
        System.out.println(table.contains("bb"));*/
//        System.out.println(table.size()+":"+table.get("a"));
    }
}
