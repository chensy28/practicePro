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
        //map�ı�������ֱ����Iterator��������Ҫ�Ƚ�key�ŵ�set��ͼ��
        //map�еļ������ظ��������ظ��ļ���������ֵ�Ὣǰ���ֵ���и���
        Map<String, String> map = new HashMap<>();
        map.put("a","AA");
        map.put("b","AA");
        map.put("c","CC");
        /*map.put(null,"dd");
        map.put(null,"ee");
        map.put("f",null); //HashMap�еļ���ֵ���ܴ�nullֵ*/
        //System.out.println(map.get(null));
        //System.out.println(map.get("f"));
        //��map�������Ȼ�ȡkey��set��Ȼ���ڶ�set���б���
        Set<String> set =  map.keySet();
        for(String str : set){      //ʹ��for���б���
           String key = str;
            String val = map.get(str);
            System.out.println(key+":"+val);
        }

       /* Iterator<String> it = set.iterator();//hashMap��ɢ�����䣬���Դ��˳����ȡ������˳����ܻ᲻һ��
        while(it.hasNext()){
            String key = it.next();
            String val = map.get(key);
            System.out.println(key + ":" + val);
        }*/
       /* for(int i=1;i<=map.size();i++){  //ʹ��keySet()��ȡ���ļ��ϣ��������ַ�������ʽƴ��key�����о����ԣ������ַ��͵�key
            System.out.println(map.get(""+i));
        }*/
    }
}
