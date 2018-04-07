package com.csy.createthread.signForDeakLock;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ���������ֹ��棨������Դ��
 * ����ʱ�䣺2016��03��13�� ����12:05
 *
 * @author csypc
 * @version 1.0
 */
public class HandSide {

    /**
     * �����������������ߵȴ����������֪ͨ������ �����ͷ���Դ sign = true
     * ���������ѣ������ߵȴ������Ѻ�֪ͨ������  �����ͷ���Դ  sign = flase
     *
     * ���׶��߳�˼�룺���Ƕ���̲߳��ϵ�������Դ���ͷ���Դ�����ݷ����ʱ��Ƭ���ٽ���
     * wait() �ͷ���Դ�� notify()�����߳� �ı��־
     */

    //����
    private String noodle;

    //�źű�־
    private boolean sign = true;

    //����
    public synchronized void doNoodle(String noodle,int i){
        if(!sign){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("��"+i+"��"+noodle);
        this.noodle = noodle;

        this.notify();

        sign = false;
    }

    //����
    public synchronized void eatNoodel(int i){

        if(sign){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("��"+i+"�ֺóԣ�");

        this.notify();
        sign = true;
    }
}
