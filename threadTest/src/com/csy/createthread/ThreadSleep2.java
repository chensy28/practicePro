package com.csy.createthread;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：sleep模拟网络延时
 * 创建时间：2016年03月10日 下午00:27
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadSleep2 {

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        Thread thread1 = new Thread(web,"黄牛甲");
        Thread thread2 = new Thread(web,"黄牛已");
        Thread thread3 = new Thread(web,"路人丙");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Web12306 implements Runnable{
    int num = 50 ;

    @Override
    public void run() {  //
        while(true){
            if(num <= 0){
                break;
            }
            //模拟网络延时
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了：还剩余"+num--+"票");
        }
    }
}
