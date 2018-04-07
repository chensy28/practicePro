package com.csy.createthread;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：线程同步 synchronized
 * 创建时间：2016年03月10日 下午08:27
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadSynchronized {

    /**
     * 同步：并发   当多个线程访问同一个资源时，若资源时安全的，则称为线程安全
     * 使用线程安全，时间就会花的多点，效率会低点
     * @param args
     */
    public static void main(String[] args) {
        WebTicket web = new WebTicket();
        //多个线程共享资源
        Thread thread1 = new Thread(web,"黄牛甲");
        Thread thread2 = new Thread(web,"黄牛已");
        Thread thread3 = new Thread(web,"路人丙");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class WebTicket implements Runnable{
    int num = 10 ;

    @Override
    public  void run() {  //加上synchronized对方法进行加锁
       // test1();
        //test2();
        test3();
    }

    //同步方法
    public synchronized void test1(){
        while(true){
            if(num <= 0){
                break;
            }
            try {
                Thread.sleep(500); //模拟网络延时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了：还剩余"+num--+"票");
        }
    }

    //同步块  synchronized(引用类型 | this | 类.class)
    public void test2(){
        synchronized(this) {
            while (true) {
                if (num <= 0) {
                    break;
                }
                try {
                    Thread.sleep(500); //模拟网络延时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "抢到了：还剩余" + num-- + "票");
            }
        }
    }

    //锁定范围不正确，线程不安全
    public void test3(){

            while (true) {
                //a,b,c = 1
                if (num <= 0) {
                    break;
                }
                //a,b,c = 1  线程不断地抢夺资源，直到抢到为止
                synchronized(this) {
                try {
                    Thread.sleep(500); //模拟网络延时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "抢到了：还剩余" + num-- + "票");
            }
        }
    }
}



