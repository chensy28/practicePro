package com.csy.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/17.
 * Time:21:40.
 */
public class ReadDeal {
    public static void main(String []args) {
        //������ֻ������
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        //��ÿ��б�����Ͱ�ȫ��ʽ  emptyList()
       /* List<String> list2 = Collections.emptyList();
        //list2.add("bb");  �������Ԫ��
        System.out.print(list2.size());*/

        //ֻ����һ��Ԫ�أ�������һ��Ԫ���򱨴�
       // List<String> list2 = Collections.singletonList(new String("aa"));
        //list2.add("a");
        //System.out.print(list2.get(0));

        //����ָ���б�Ĳ����޸���ͼ��
       List<String> newList = Collections.unmodifiableList(list);
        System.out.print(newList.size());
        //newList.add("cc");
    }
}
