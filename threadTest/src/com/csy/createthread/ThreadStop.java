package com.csy.createthread;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������ֹͣ�߳�(�Զ��巽�� ���ⲿ����)
 * ����ʱ�䣺2016��03��08�� ����21:32
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadStop {
    public static void main(String[] args) {
        //����Thread�����ṩ��stop������ʱ�ˣ�����ȫ�����Զ��巨ֹͣ�̵߳ķ���
        Study study = new Study();
        Thread thread = new Thread(study);
        thread.start();
        for(int i=0;i<100;i++){
            if(50 == i){
                study.stop();
            }
            System.out.println("main....."+i);
        }

    }
}

class Study implements Runnable{

    //�����߳���ʹ�õı�־
    private boolean flag = true;
    @Override
    public void run() {
        //ʹ�ñ�־
        while(flag){
            System.out.println("Thread start ��");
        }
    }

    //�����ṩ�ı��־�ķ���
    public void stop(){
        this.flag = false;
    }
}
