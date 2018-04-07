package com.csy.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/13.
 * Time:21:00.
 */
public class HashMapTest {
    public static void main(String []args) {
        //map的遍历不能直接用Iterator遍历，需要先将key放到set视图中
        //map中的键不能重复，若有重复的键，则后面的值会将前面的值进行覆盖
        Map<String, String> map = new HashMap<>();
        map.put("a","AA");
        map.put("b","AA");
        map.put("c","CC");
        /*map.put(null,"dd");
        map.put(null,"ee");
        map.put("f",null); //HashMap中的键、值都能存null值*/
        //System.out.println(map.get(null));
        //System.out.println(map.get("f"));
        //将map遍历，先获取key的set，然后在对set进行遍历
        Set<String> set =  map.keySet();
        for(String str : set){      //使用for进行遍历
           String key = str;
            String val = map.get(str);
            System.out.println(key+":"+val);
        }

       /* Iterator<String> it = set.iterator();//hashMap是散列隐射，所以存的顺序与取出来的顺序可能会不一样
        while(it.hasNext()){
            String key = it.next();
            String val = map.get(key);
            System.out.println(key + ":" + val);
        }*/
       /* for(int i=1;i<=map.size();i++){  //使用keySet()获取键的集合，若采用字符串的形式拼接key，具有局限性，比如字符型的key
            System.out.println(map.get(""+i));
        }*/
    }
}
