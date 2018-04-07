package com.csy.createthread;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/12/23.
 * Time:22:18.
 */
public class Robbit extends Thread{
    @Override
    public void run(){
        for (int i=0;i<3;i++) {
            System.out.println("兔子走了："+i+"步");
        }
    }
}
