package com.csy.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/17.
 * Time:21:29.
 */
public class SynchronizeForVector {
    public static void main(String []args){
        List<String> list = new ArrayList<>();
        list.add("aa");
        //ʹ��Collections�ķ�����������Ӧ��Ϊ�̰߳�ȫ��
        List<String> newList = Collections.synchronizedList(list);
        newList.add("bb");
        System.out.print(newList.size());
    }
}
