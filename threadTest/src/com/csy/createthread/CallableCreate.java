package com.csy.createthread;

import java.util.concurrent.*;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：通过Callable和Future创建线程
 * 创建时间：2016年03月07日 下午21:58
 *
 * @author csypc
 * @version 1.0
 */
public class CallableCreate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
         //创建线程
        ExecutorService service = Executors.newFixedThreadPool(1);
        Race race = new Race();
        //获取值
        Future<Integer> future = service.submit(race);
        int result = future.get();
        System.out.println(result);

        //停止服务
        service.shutdownNow();
    }
}

class Race implements Callable<Integer>{
    //具有返回值并且抛出异常
    @Override
    public Integer call() throws Exception {

        //在此处加上业务处理
        return 1020;
    }
}
