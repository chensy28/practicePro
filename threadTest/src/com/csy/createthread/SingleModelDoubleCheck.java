package com.csy.createthread;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�����ģʽ ˫�ؼ��
 * ���������ڶ��̵߳�ʱ�򣬴����Ķ�����ܲ�һ����������Ҫͬ������
 * ����ʱ�䣺2016��03��10�� ����22:50
 *
 * @author csypc
 * @version 1.0
 */
public class SingleModelDoubleCheck {

    public static void main(String[] args) {
        SingletonThread thread1 = new SingletonThread();
        SingletonThread thread2 = new SingletonThread();
        SingletonThread thread3 = new SingletonThread();

        //���ö���߳�
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

        //��������ͬ�����������Ķ�����ܲ�һ��
        System.out.println("�����Ķ���1��"+SingleModel2.getInstance().hashCode());
        System.out.println("�����Ķ���2��"+SingleModel2.getInstance().hashCode());
        System.out.println("�����Ķ���3��"+SingleModel2.getInstance().hashCode());
    }
}

class SingleModel2 {

    //����һ��˽�еľ�̬����
    private static SingleModel2 singleModel2 = null;

    //������˽�л��������ⲿֱ�Ӵ�������
    private SingleModel2() {

    }

    //����һ�����еķ������ʱ������������û�ж����򴴽�����
    public /*synchronized */ static SingleModel2 getInstance() {           //synchronized����ͬ��ʱ����Ҫ���Ƿ�Χ�Լ�Ч��

        //˫��check,���Ч��
        if(null == singleModel2) {
            //a b c ��ͬ����
            synchronized (SingleModel2.class) {
                if (null == singleModel2) {
                    singleModel2 = new SingleModel2();
                }

            }
        }
        return singleModel2;
    }
}
