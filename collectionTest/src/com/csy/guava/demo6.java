package com.csy.guava;

import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.multiset.HashMultiSet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�demo6
 * ��������Multset :����+���ظ�
 * ����ʱ�䣺2016��01��20�� ����23:04
 *
 * @author csypc
 * @version 1.0
 */
public class demo6 {
    public static void main(String[] args) {

        //ͳ�Ƶ��ʳ��ֵĴ���
        String str = "returns the number of occurrences of the given object currently in the multiSet";

        String []arr = str.split(" ");
        //����+���ظ�
        MultiSet<String> set = new HashMultiSet<>();
        for(int i =0;i<arr.length;i++){
            set.add(arr[i]);
        }

        //��set��Ϊ�����ظ��ģ�Ψһ��ֵ
        Set<String> tempset = set.uniqueSet();
        for(String s : tempset){
            System.out.println(s+"����"+set.getCount(s)+"��");
        }

        //ʹ��map�洢��map�������ظ������м�����ͬ�ģ�����Ӧ��ֵ�ᱻ����
       /* Map<String,Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++) {
            map.put(arr[i], set.getCount(arr[i]));
        }

        //��mapת��Ϊset���б���
        Set set1 = map.keySet();
        Iterator it = set1.iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            System.out.println(key+"����"+map.get(key)+"��");
        }*/

    }
}
