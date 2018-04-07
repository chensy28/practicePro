package com.csy.createthread;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������sleepģ��������ʱ
 * ����ʱ�䣺2016��03��10�� ����00:27
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadSleep2 {

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        Thread thread1 = new Thread(web,"��ţ��");
        Thread thread2 = new Thread(web,"��ţ��");
        Thread thread3 = new Thread(web,"·�˱�");

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
            //ģ��������ʱ
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"�����ˣ���ʣ��"+num--+"Ʊ");
        }
    }
}
