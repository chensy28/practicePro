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
        //�ײ�ʵ��������(˫�˶���)
        ArrayDeque queue = new ArrayDeque<>();
       queue.addFirst("aa");//��ͷ������Ԫ��
        queue.addFirst("cc");
        queue.addFirst("bb");
        queue.addFirst("dd");

        System.out.println(queue.getFirst());
        System.out.println(queue.getLast());
        /*queue.addLast("aa");//��ͷ������Ԫ��
        queue.addLast("cc");
        queue.addLast("bb");
        queue.addLast("dd");*/

       /* queue.push("aa");   //ģ��ջ��ջ��ջ
        queue.push("cc");
        queue.push("bb");
        queue.push("dd");
        System.out.println(queue.pop());*/

        //����ѭ��
       /* Iterator it = queue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
           // System.out.println(queue.pop());
            //System.out.println(queue.peek());
        }*/
    }
}
