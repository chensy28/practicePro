package com.csy.set;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/14.
 * Time:7:52.
 */
public class SetTest {
    public static void main(String []args){
        //set的底层结构是map，添加时，是将添加的值作为key存入map，获取时，利用iterator遍历key的集合
        Set set = new HashSet<>();  //若不指定类型如Set<String> 默认为Object类型
        set.add("aa");
        set.add(new Integer(1));
        set.add("cc");

        /*Set set2 = new HashSet<>();
        set2.add("bb");
        set2.add("ee");*/

       // set.retainAll(set2); 求交集   指定的集合不能为null
       // System.out.println(set.contains("aa"));  是否包含
        //set.clear();
        //set.addAll(set2); 求并集   指定的集合不能为null

      /*Iterator<String> iterator = set.iterator();  //使用iterator遍历集合
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }*/
       /* Object [] arr = set.toArray();    //使用for增强遍历
        for(Object obj : arr){
            System.out.print(obj+" ");
        }*/
        for(Object obj : set){            //直接将set进行遍历
            System.out.print(obj+" ");
        }


//        System.out.println(set.size());
        //List list; //继承Collection接口
       // Map map = new HashMap<>();   //没有继承Collection接口
    }
}