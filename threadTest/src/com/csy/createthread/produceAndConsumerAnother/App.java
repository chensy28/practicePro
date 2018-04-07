package com.csy.createthread.produceAndConsumerAnother;

/**
 * 项目名称：
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月12日 下午21:05
 *
 * @author csypc
 * @version 1.0
 */
public class App {
    public static void main(String[] args) {
        //公共资源
        Movie movie = new Movie();
        //生产者
        Player player = new Player(movie);
        //消费者
        Watcher watcher = new Watcher(movie);

        Thread thread1 = new Thread(player,"生产者");
        Thread thread2 = new Thread(watcher,"消费者");

        thread1.start();
        thread2.start();

        System.out.println("main thread!!");
    }
}
