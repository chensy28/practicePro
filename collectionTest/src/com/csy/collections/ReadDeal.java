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
        //容器的只读控制
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        //获得空列表的类型安全方式  emptyList()
       /* List<String> list2 = Collections.emptyList();
        //list2.add("bb");  不能添加元素
        System.out.print(list2.size());*/

        //只包含一个元素，若超过一个元素则报错
       // List<String> list2 = Collections.singletonList(new String("aa"));
        //list2.add("a");
        //System.out.print(list2.get(0));

        //返回指定列表的不可修改视图。
       List<String> newList = Collections.unmodifiableList(list);
        System.out.print(newList.size());
        //newList.add("cc");
    }
}
