package com.csy.createthread.signForDeakLock;

/**
 * 项目名称：
 * 类名称：
 * 类描述：手工面（公共资源）
 * 创建时间：2016年03月13日 下午12:05
 *
 * @author csypc
 * @version 1.0
 */
public class HandSide {

    /**
     * 生产者生产，消费者等待，生产完后通知消费者 并且释放资源 sign = true
     * 消费者消费，生产者等待，消费后通知生产者  并且释放资源  sign = flase
     *
     * 明白多线程思想：就是多个线程不断的抢夺资源，释放资源，根据分配的时间片快速交换
     * wait() 释放资源后 notify()唤醒线程 改变标志
     */

    //面条
    private String noodle;

    //信号标志
    private boolean sign = true;

    //做面
    public synchronized void doNoodle(String noodle,int i){
        if(!sign){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("第"+i+"种"+noodle);
        this.noodle = noodle;

        this.notify();

        sign = false;
    }

    //吃面
    public synchronized void eatNoodel(int i){

        if(sign){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("第"+i+"种好吃！");

        this.notify();
        sign = true;
    }
}
