package com.csy.createthread.produceAndConsumerAnother;

/**
 * 项目名称：
 * 类名称：
 * 类描述：生产者
 * 创建时间：2016年03月12日 下午20:54
 *
 * @author csypc
 * @version 1.0
 */
public class Player implements Runnable {
    private Movie movie;

    public Player(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
         for(int i=0;i<2;i++){
             if(0 == i%2){
                 //生产者生产,为公共资源设值
                 movie.play("左青龙");
             }else{
                 movie.play("右白虎");
             }
         }
    }
}
