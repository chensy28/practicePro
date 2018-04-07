package com.csy.createthread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������ʱ����
 * ����ʱ�䣺2016��03��13�� ����20:11
 *
 * @author csypc
 * @version 1.0
 */
public class ScheduleTest {
    public static void main(String[] args) throws InterruptedException {

        //������ʱ��
        Timer timer = new Timer();

        //������ָ����ʱ��ִ��ָ��������
        timer.schedule(new TimerTask() {
            //TimerTaskʵ��Runnable����ʱ������
            @Override
            public void run() {
                System.out.println("time schedule...");
            }
        },new Date(System.currentTimeMillis()),1000);

        Thread.sleep(1000);

        //��ֹ�˼�ʱ�����������е�ǰ�Ѱ��ŵ�����
        timer.cancel();
    }
}
