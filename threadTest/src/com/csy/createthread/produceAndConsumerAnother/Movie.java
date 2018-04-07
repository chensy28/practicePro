package com.csy.createthread.produceAndConsumerAnother;

/**
 * 项目名称：
 * 类名称：wait()释放资源，sleep()不释放资源
 * 类描述：公有资源 使用信号灯法处理
 * 创建时间：2016年03月12日 下午09:15
 *
 * @author csypc
 * @version 1.0
 */
public class Movie {
    /**
     * 生产者生产，消费者等待，生产完后通知消费者 sign = true
     * 消费者消费，生产者等待，消费后通知生产者    sign = flase
     *
     * 明白多线程思想：就是多个线程不断的抢夺资源，释放资源，根据分配的时间片快速交换
     * wait() 释放资源后 notify()唤醒线程 改变标志
     */

    private String pic;
    //信号标志
    private boolean sign = true;

    //生产者调用方法,this表示生产者
    public synchronized void play(String pic){
        if(!sign) {
            try {
                //生产者等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //开始生产
       try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //生产完毕
        this.pic = pic;
        System.out.println("生产了："+this.pic);

        //唤醒等待的线程（消费者）
        this.notifyAll();
        //改变标志（让当前线程wait()）
        sign = false;
    }

    //消费者调用方法,this表示消费者
    public synchronized void watch(){
        if(sign) {
            try {
                //消费者等待
                this.wait(); //释放资源，当前线程暂挂，切换到其它线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //消费者消费
       try {
            Thread.sleep(1000);//具体的业务逻辑
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("消费了："+this.pic);

        //唤醒等待的线程（生产者）
        this.notifyAll();
        sign = true;

    }

}
