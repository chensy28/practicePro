package com.csy.arraylist;

import com.csy.arraylist.ArrayListTest;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/12/24.
 * Time:22:21.
 */
public class Test {
    public static void main(String []args){
        ArrayListTest list = new ArrayListTest();
        for(int i=0;i<5;i++){
            list.add(i);
        }
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        ArrayList arrayList = new ArrayList();
    }
}
