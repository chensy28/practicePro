package com.csy.createthread;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������ʹ��yield�����߳�
 * ����ʱ�䣺2016��03��08�� ����23:13
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadYield extends ThreadJoin{
    public static void main(String[] args) {  //main�̵߳��߳���
        ThreadYield threadJoin = new ThreadYield();//��ʵ��ɫ
        Thread t = new Thread(threadJoin);//����״̬�������ɫ��
        t.start();//����״̬
        for(int i=0;i<1000;i++){
            if(i % 20 == 0){
                Thread.yield();//��ͣ��ǰ�߳�main,д���ĸ��߳��壬����ͣ�ĸ��߳�
            }
            System.out.println("main-->"+i);
        }
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("join-->"+i);
        }
    }
}
