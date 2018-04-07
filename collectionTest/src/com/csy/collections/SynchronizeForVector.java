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
        //使用Collections的方法将容器对应变为线程安全的
        List<String> newList = Collections.synchronizedList(list);
        newList.add("bb");
        System.out.print(newList.size());
    }
}
