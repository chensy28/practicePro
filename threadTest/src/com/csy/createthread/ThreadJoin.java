package com.csy.createthread;


/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ���������߳�����
 * ����ʱ�䣺2016��03��08�� ����22:10
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadJoin extends Thread{
    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();//��ʵ��ɫ
        Thread t = new Thread(threadJoin);//����״̬�������ɫ��
        t.start();//����״̬
        System.out.println("�߳�����"+t.getName()+"�߳���:"+Thread.activeCount());  //3���̣߳��������̣߳�
        System.out.println("��ǰ�̣߳�"+Thread.currentThread());
        //����߳�cpu�����ʱ��Ƭ�н������
        for(int i=0;i<1000;i++){
           if(50 == i){
                //t.join();//��i����50֮ǰ���߳̽������У�����50֮�󣬽��̺߳ϲ�Ϊһ��·��
               t.join(10);//�ȴ����߳���ֹ��ʱ���Ϊ millis ����,����ָ��ʱ�䣬�Ͳ�������  main����
            }
            //t.join();//��·���ϲ�һ�����ϲ���һ��·��ִ�����ˣ���ִ����һ��
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
