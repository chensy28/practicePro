package com.csy.queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/16.
 * Time:10:51.
 */
public class ArrayQueueTest {
    public static void main(String []args){
        ArrayQueue queue = new ArrayQueue(10);
        queue.add("11");
        queue.add("22");
        queue.add("33");

//        queue.add(3,"44"); 不支持操作
//        System.out.println(queue.get(2));取值
        //遍历循环
        /*Iterator it = queue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/
    }
}
