package com.csy.createthread.produceAndConsumerAnother;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��12�� ����21:05
 *
 * @author csypc
 * @version 1.0
 */
public class App {
    public static void main(String[] args) {
        //������Դ
        Movie movie = new Movie();
        //������
        Player player = new Player(movie);
        //������
        Watcher watcher = new Watcher(movie);

        Thread thread1 = new Thread(player,"������");
        Thread thread2 = new Thread(watcher,"������");

        thread1.start();
        thread2.start();

        System.out.println("main thread!!");
    }
}
