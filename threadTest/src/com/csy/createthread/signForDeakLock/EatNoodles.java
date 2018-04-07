package com.csy.createthread.signForDeakLock;

/**
 * 项目名称：
 * 类名称：
 * 类描述：吃面（场景）
 * 创建时间：2016年03月13日 下午12:10
 *
 * @author csypc
 * @version 1.0
 */
public class EatNoodles {
    public static void main(String[] args) {
        HandSide handSide = new HandSide();

        Cook cook = new Cook(handSide);
        Consumer consumer = new Consumer(handSide);

        //两个线程启动后，都会去抢夺资源
        new Thread(cook,"厨师").start();
        new Thread(consumer,"吃客").start();

    }
}
