package com.csy.createthread;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/12/23.
 * Time:22:18.
 */
public class Tortoise extends Thread{
    @Override
    public void run(){
     /* for (int i=0;i<10;i++) {
            System.out.println("�ڹ����ˣ�" + i + "��");
        }*/
    }
}

class Dog extends Thread{
    @Override
    public void run(){
        for (int i=0;i<5;i++) {
            System.out.println("�����ˣ�" + i + "��");
        }
    }
}
