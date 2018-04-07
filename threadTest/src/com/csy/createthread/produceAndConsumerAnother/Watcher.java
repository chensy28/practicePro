package com.csy.createthread.produceAndConsumerAnother;

/**
 * 项目名称：
 * 类名称：
 * 类描述：消费者
 * 创建时间：2016年03月12日 下午20:55
 *
 * @author csypc
 * @version 1.0
 */
public class Watcher implements Runnable {
    private Movie movie;

    public Watcher(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for(int i=0;i<2;i++) {
            //消费者消费,消费公共资源
           movie.watch();
        }
    }
}
