package com.csy.createthread.signForDeakLock;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��13�� ����12:09
 *
 * @author csypc
 * @version 1.0
 */
public class Consumer implements Runnable{

    private HandSide handSide;

    public Consumer(HandSide handSide) {
        this.handSide = handSide;
    }

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            handSide.eatNoodel(i);
        }
    }
}
