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
        //��ת�Ͷ����ǲ������࣬���Ե���������д��̳еķ����������������ķ������ò���
        Queue queue = new ArrayDeque<>();
        queue.add("aa");//���Ԫ��
        queue.offer("bb");//���Ԫ��
        queue.offer("cc");//���Ԫ��
        queue.offer("dd");//���Ԫ��
        queue.offer("ee");//���Ԫ��
        //System.out.println(queue.peek()); ȡͷԪ�أ����Ƴ�
       //queue.poll();     //ȡͷԪ�أ������Ƴ�
        //queue.remove();  //��ȡ���Ƴ��˶��е�ͷ��
        //����ѭ��
        Iterator it = queue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //ȡͷԪ��
       // System.out.println(queue.element());

    }
}
