package com.csy.createthread;

/**
 * ��Ŀ���ƣ�
 * �����ƣ��������������(����ʹ��ͬ��)
 * ��������
 * ����ʱ�䣺2016��03��11�� ����21:54
 *
 * @author csypc
 * @version 1.0
 */
public class DeadLockPro {
    public static void main(String[] args) {
         Object goods = new Object();
         Object money = new Object();
         //����̹߳����еĶ��󣬲��Ҷ���ס�ˣ��˴˶����ͷţ����������
         DeakLock1 deakLock = new DeakLock1(goods,money);
         DeakLock2 deakLock2 = new DeakLock2(goods,money);

         Thread thread = new Thread(deakLock);
         Thread thread1 = new Thread(deakLock2);

        //�����߳�
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
                System.out.println("һ�ֽ���������");
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
                Thread.sleep(200);//�ӳ�ʱ�䣬�������Ĵ���
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goods){
                System.out.println("һ�ֽ�Ǯ������");
            }
        }
    }
}

