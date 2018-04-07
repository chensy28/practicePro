package com.csy.guava;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�demo1
 * ��������guvaֻ��
 * ����ʱ�䣺2016��01��19�� ����12:47
 *
 * @author csypc
 * @version 1.0
 */
public class demo1 {
    public static void main(String []args) {
        //������ֻ������
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");

        //ʹ��Collections����ֻ��������ȫ����Ϊԭ�б�ı��ˣ��������б�Ҳ���Ÿı���
      /*  List<String> newList = Collections.unmodifiableList(list);
        list.add("cc");
        Iterator<String> it = newList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.print(newList.size());*/

        //ʹ��guava�ṩ�Ĳ�����չ���б���򵥷���
        List<String> newList = ImmutableList.of("aa","bb","cc");
        //newList.add("dd"); //������չ
        Iterator<String> it = newList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.print(newList.size());
    }
}
