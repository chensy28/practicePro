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
        //此时的键是同一个地址
        map.put("a","11");
        map.put("a","22");
        System.out.println(map.size());  //输出1
        System.out.println(map.get("a"));

        //此时的键不是同一个地址
        map.put(new String("a"), "33");
        map.put(new String("a"),"44");
        System.out.println(map.size());  //输出3
        //System.out.println(map.get(new String("a")));输出null

        Set<String> set =  map.keySet();
        for(String str : set){      //使用for进行遍历
            String key = str;
            String val = map.get(str);
            System.out.println(key+":"+val);
        }
    }
}
