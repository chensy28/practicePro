package com.csy.createthread.signForDeakLock;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������ʦ�������ߣ�
 * ����ʱ�䣺2016��03��13�� ����12:08
 *
 * @author csypc
 * @version 1.0
 */
public class Cook implements Runnable  {

    private HandSide handSide;

    public Cook(HandSide handSide) {
        this.handSide = handSide;
    }

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            //���ù�����Դ�ķ���
            handSide.doNoodle("�ֹ���",i);
        }
    }
}
