package com.csy.createthread;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��07�� ����08:56
 *
 * @author csypc
 * @version 1.0
 */
public class RunnableCreate implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        //��ʵ��ɫ
        RunnableCreate create = new RunnableCreate();
        //�����ɫ
        Thread thread = new Thread(create);
        thread.start();
    }
}
