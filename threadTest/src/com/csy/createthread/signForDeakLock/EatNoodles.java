package com.csy.createthread.signForDeakLock;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * �����������棨������
 * ����ʱ�䣺2016��03��13�� ����12:10
 *
 * @author csypc
 * @version 1.0
 */
public class EatNoodles {
    public static void main(String[] args) {
        HandSide handSide = new HandSide();

        Cook cook = new Cook(handSide);
        Consumer consumer = new Consumer(handSide);

        //�����߳������󣬶���ȥ������Դ
        new Thread(cook,"��ʦ").start();
        new Thread(consumer,"�Կ�").start();

    }
}
