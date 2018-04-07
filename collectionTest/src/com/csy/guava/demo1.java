package com.csy.guava;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 项目名称：springbasic
 * 类名称：demo1
 * 类描述：guva只读
 * 创建时间：2016年01月19日 下午12:47
 *
 * @author csypc
 * @version 1.0
 */
public class demo1 {
    public static void main(String []args) {
        //容器的只读控制
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");

        //使用Collections处理只读，不安全，因为原列表改变了，处理后的列表也跟着改变了
      /*  List<String> newList = Collections.unmodifiableList(list);
        list.add("cc");
        Iterator<String> it = newList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.print(newList.size());*/

        //使用guava提供的不可扩展的列表更简单方便
        List<String> newList = ImmutableList.of("aa","bb","cc");
        //newList.add("dd"); //不能扩展
        Iterator<String> it = newList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.print(newList.size());
    }
}
