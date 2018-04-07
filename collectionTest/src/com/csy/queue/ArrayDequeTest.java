package com.csy.queue;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/16.
 * Time:11:10.
 */
public class ArrayDequeTest {
    public static void main(String []args) {
        //底层实现是数组(双端队列)
        ArrayDeque queue = new ArrayDeque<>();
       queue.addFirst("aa");//在头部加入元素
        queue.addFirst("cc");
        queue.addFirst("bb");
        queue.addFirst("dd");

        System.out.println(queue.getFirst());
        System.out.println(queue.getLast());
        /*queue.addLast("aa");//在头部加入元素
        queue.addLast("cc");
        queue.addLast("bb");
        queue.addLast("dd");*/

       /* queue.push("aa");   //模拟栈入栈初栈
        queue.push("cc");
        queue.push("bb");
        queue.push("dd");
        System.out.println(queue.pop());*/

        //遍历循环
       /* Iterator it = queue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
           // System.out.println(queue.pop());
            //System.out.println(queue.peek());
        }*/
    }
}
