package com.csy.guava;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�demo5
 * ��������set�Ľ������������
 * ����ʱ�䣺2016��01��20�� ����09:11
 *
 * @author csypc
 * @version 1.0
 */
public class demo5 {
    public static void main(String[] args) {
        Set<Integer> set1 = Sets.newHashSet(1,2,3,4,5,6);
        Set<Integer> set2 = Sets.newHashSet(4,5,6,7);
        Set<Integer> set3 = Sets.newHashSet(1,4,6,9);

        //�󽻼�
      /*  Sets.SetView<Integer> setView = Sets.intersection(set1, set2);
        for(Integer i : setView){
            System.out.println(i);
        }*/

        //��
        /*Sets.SetView<Integer> setView = Sets.difference(set1, set2);
        for(Integer i : setView){
            System.out.println(i);
        }*/

        //�󲢼�
        Sets.SetView<Integer> setView = Sets.union(set1, set2);
        for(Integer i : setView){
            System.out.println(i);
        }
    }
}
