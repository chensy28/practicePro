package com.csy.createthread;

/**
 * 项目名称：
 * 类名称：出现死锁的情况(过多使用同步)
 * 类描述：
 * 创建时间：2016年03月11日 下午21:54
 *
 * @author csypc
 * @version 1.0
 */
public class DeadLockPro {
    public static void main(String[] args) {
         Object goods = new Object();
         Object money = new Object();
         //多个线程共享公有的对象，并且都锁住了，彼此都不释放，就造成死锁
         DeakLock1 deakLock = new DeakLock1(goods,money);
         DeakLock2 deakLock2 = new DeakLock2(goods,money);

         Thread thread = new Thread(deakLock);
         Thread thread1 = new Thread(deakLock2);

        //启动线程
         thread.start();
         thread1.start();
    }
}

class DeakLock1 implements Runnable{

    Object goods;
    Object money;
    public DeakLock1(){}
    public DeakLock1(Object goods, Object money) {
        super();
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        test();
    }

    public void test(){
        synchronized(goods){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (money){
                System.out.println("一手交货。。。");
            }
        }
    }

}

class DeakLock2 implements Runnable{

    Object goods;
    Object money;

    public DeakLock2(){}
    public DeakLock2(Object goods, Object money) {
        super();
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        test2();
    }

    public void test2(){
        synchronized(money){
            try {
                Thread.sleep(200);//延长时间，扩大发生的错误
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goods){
                System.out.println("一手交钱。。。");
            }
        }
    }
}

