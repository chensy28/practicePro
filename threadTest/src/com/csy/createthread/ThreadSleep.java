package com.csy.createthread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������sleepģ�⵹��ʱ
 * ����ʱ�䣺2016��03��09�� ����23:09
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        /*//����10����
        int num = 10;
        boolean flag= true;
        while(flag){
            System.out.println(num--);
            //�õ�ǰ�߳����ߣ����ͷ���
            Thread.sleep(1000);
            if(num<=0){
                break;
            }
        }*/

        //����ʱ
        Date endTime = new Date(System.currentTimeMillis());
        Long end = endTime.getTime();
        while(true){
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(endTime));
            Thread.sleep(1000);
            //ʱ�����һ�루����ʱ�䣩
            endTime = new Date(endTime.getTime()-1000);
            //����ѭ���ı߽�
            if(end - 10*1000 > endTime.getTime()){
                   break;
            }
        }


    }
}
