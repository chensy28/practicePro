package com.csy.map;

import java.util.IdentityHashMap;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/17.
 * Time:9:07.
 */
public class IdentityHashMapTest {
    public static void main(String []args) {
        IdentityHashMap<String,String> map = new IdentityHashMap<>();
        //��ʱ�ļ���ͬһ����ַ
        map.put("a","11");
        map.put("a","22");
        System.out.println(map.size());  //���1
        System.out.println(map.get("a"));

        //��ʱ�ļ�����ͬһ����ַ
        map.put(new String("a"), "33");
        map.put(new String("a"),"44");
        System.out.println(map.size());  //���3
        //System.out.println(map.get(new String("a")));���null

        Set<String> set =  map.keySet();
        for(String str : set){      //ʹ��for���б���
            String key = str;
            String val = map.get(str);
            System.out.println(key+":"+val);
        }
    }
}
