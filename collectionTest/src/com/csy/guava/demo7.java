package com.csy.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�demo7
 * ��������MultiMap �������ظ�
 * ����ʱ�䣺2016��01��21�� ����00:13
 *
 * @author csypc
 * @version 1.0
 */
public class demo7 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        /*map.put("1","aa");
        map.put("1","bb");
        map.put("2","aa");
        map.put("3","cc");*/

        Multimap<String,String> multimap = ArrayListMultimap.create();
        multimap.put("1","aa");
        multimap.put("1","aa");
        multimap.put("2","aa");
        multimap.put("3","cc");

       // Collection col = multimap.get("1");
       /* MultiSet set = multimap.keys();
        Iterator it = col.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/


    }
}
