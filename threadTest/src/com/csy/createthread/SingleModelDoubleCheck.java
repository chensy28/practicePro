package com.csy.createthread;

/**
 * 项目名称：
 * 类名称：单例模式 双重检查
 * 类描述：在多线程的时候，创建的对象可能不一样，所以需要同步处理
 * 创建时间：2016年03月10日 下午22:50
 *
 * @author csypc
 * @version 1.0
 */
public class SingleModelDoubleCheck {

    public static void main(String[] args) {
        SingletonThread thread1 = new SingletonThread();
        SingletonThread thread2 = new SingletonThread();
        SingletonThread thread3 = new SingletonThread();

        //启用多个线程
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class SingletonThread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //若不进行同步处理，创建的对象可能不一样
        System.out.println("创建的对象1："+SingleModel2.getInstance().hashCode());
        System.out.println("创建的对象2："+SingleModel2.getInstance().hashCode());
        System.out.println("创建的对象3："+SingleModel2.getInstance().hashCode());
    }
}

class SingleModel2 {

    //声明一个私有的静态变量
    private static SingleModel2 singleModel2 = null;

    //构造器私有化，避免外部直接创建对象
    private SingleModel2() {

    }

    //创建一个公有的方法访问变量，如果变量没有对象，则创建对象
    public /*synchronized */ static SingleModel2 getInstance() {           //synchronized进行同步时，需要考虑范围以及效率

        //双重check,提高效率
        if(null == singleModel2) {
            //a b c 共同到此
            synchronized (SingleModel2.class) {
                if (null == singleModel2) {
                    singleModel2 = new SingleModel2();
                }

            }
        }
        return singleModel2;
    }
}
