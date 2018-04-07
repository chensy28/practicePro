package com.csy.queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/15.
 * Time:13:06.
 */
public class QueueTest {

    public static void main(String []args){
        //上转型对象，是部分子类，可以调用子类重写或继承的方法，而子类新增的方法调用不了
        Queue queue = new ArrayDeque<>();
        queue.add("aa");//添加元素
        queue.offer("bb");//添加元素
        queue.offer("cc");//添加元素
        queue.offer("dd");//添加元素
        queue.offer("ee");//添加元素
        //System.out.println(queue.peek()); 取头元素，不移除
       //queue.poll();     //取头元素，并且移除
        //queue.remove();  //获取并移除此队列的头。
        //遍历循环
        Iterator it = queue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //取头元素
       // System.out.println(queue.element());

    }
}
