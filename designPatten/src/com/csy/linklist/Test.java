package com.csy.linklist;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/12/24.
 * Time:22:21.
 */
public class Test {
    public static void main(String []args){
        LinkListTest list = new LinkListTest();
        for(int i=0;i<5;i++){
            Node node = new Node();
            //node.setNext(null);
            node.setData(String.valueOf(i));
            list.add(node);
        }
        System.out.println(list.size());
       /* for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getData());
        }*/

    }
}
