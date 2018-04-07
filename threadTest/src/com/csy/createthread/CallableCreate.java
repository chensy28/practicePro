package com.csy.createthread;

import java.util.concurrent.*;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������ͨ��Callable��Future�����߳�
 * ����ʱ�䣺2016��03��07�� ����21:58
 *
 * @author csypc
 * @version 1.0
 */
public class CallableCreate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
         //�����߳�
        ExecutorService service = Executors.newFixedThreadPool(1);
        Race race = new Race();
        //��ȡֵ
        Future<Integer> future = service.submit(race);
        int result = future.get();
        System.out.println(result);

        //ֹͣ����
        service.shutdownNow();
    }
}

class Race implements Callable<Integer>{
    //���з���ֵ�����׳��쳣
    @Override
    public Integer call() throws Exception {

        //�ڴ˴�����ҵ����
        return 1020;
    }
}
