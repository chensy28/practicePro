package com.csy.createthread.produceAndConsumerAnother;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�wait()�ͷ���Դ��sleep()���ͷ���Դ
 * ��������������Դ ʹ���źŵƷ�����
 * ����ʱ�䣺2016��03��12�� ����09:15
 *
 * @author csypc
 * @version 1.0
 */
public class Movie {
    /**
     * �����������������ߵȴ����������֪ͨ������ sign = true
     * ���������ѣ������ߵȴ������Ѻ�֪ͨ������    sign = flase
     *
     * ���׶��߳�˼�룺���Ƕ���̲߳��ϵ�������Դ���ͷ���Դ�����ݷ����ʱ��Ƭ���ٽ���
     * wait() �ͷ���Դ�� notify()�����߳� �ı��־
     */

    private String pic;
    //�źű�־
    private boolean sign = true;

    //�����ߵ��÷���,this��ʾ������
    public synchronized void play(String pic){
        if(!sign) {
            try {
                //�����ߵȴ�
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //��ʼ����
       try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //�������
        this.pic = pic;
        System.out.println("�����ˣ�"+this.pic);

        //���ѵȴ����̣߳������ߣ�
        this.notifyAll();
        //�ı��־���õ�ǰ�߳�wait()��
        sign = false;
    }

    //�����ߵ��÷���,this��ʾ������
    public synchronized void watch(){
        if(sign) {
            try {
                //�����ߵȴ�
                this.wait(); //�ͷ���Դ����ǰ�߳��ݹң��л��������߳�
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //����������
       try {
            Thread.sleep(1000);//�����ҵ���߼�
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("�����ˣ�"+this.pic);

        //���ѵȴ����̣߳������ߣ�
        this.notifyAll();
        sign = true;

    }

}
