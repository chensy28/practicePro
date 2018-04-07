package com.csy.createthread;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ���������߳�ͬ�� synchronized
 * ����ʱ�䣺2016��03��10�� ����08:27
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadSynchronized {

    /**
     * ͬ��������   ������̷߳���ͬһ����Դʱ������Դʱ��ȫ�ģ����Ϊ�̰߳�ȫ
     * ʹ���̰߳�ȫ��ʱ��ͻỨ�Ķ�㣬Ч�ʻ�͵�
     * @param args
     */
    public static void main(String[] args) {
        WebTicket web = new WebTicket();
        //����̹߳�����Դ
        Thread thread1 = new Thread(web,"��ţ��");
        Thread thread2 = new Thread(web,"��ţ��");
        Thread thread3 = new Thread(web,"·�˱�");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class WebTicket implements Runnable{
    int num = 10 ;

    @Override
    public  void run() {  //����synchronized�Է������м���
       // test1();
        //test2();
        test3();
    }

    //ͬ������
    public synchronized void test1(){
        while(true){
            if(num <= 0){
                break;
            }
            try {
                Thread.sleep(500); //ģ��������ʱ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"�����ˣ���ʣ��"+num--+"Ʊ");
        }
    }

    //ͬ����  synchronized(�������� | this | ��.class)
    public void test2(){
        synchronized(this) {
            while (true) {
                if (num <= 0) {
                    break;
                }
                try {
                    Thread.sleep(500); //ģ��������ʱ
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "�����ˣ���ʣ��" + num-- + "Ʊ");
            }
        }
    }

    //������Χ����ȷ���̲߳���ȫ
    public void test3(){

            while (true) {
                //a,b,c = 1
                if (num <= 0) {
                    break;
                }
                //a,b,c = 1  �̲߳��ϵ�������Դ��ֱ������Ϊֹ
                synchronized(this) {
                try {
                    Thread.sleep(500); //ģ��������ʱ
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "�����ˣ���ʣ��" + num-- + "Ʊ");
            }
        }
    }
}



