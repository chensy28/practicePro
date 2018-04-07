package com.csy.createthread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 项目名称：
 * 类名称：
 * 类描述：定时任务
 * 创建时间：2016年03月13日 下午20:11
 *
 * @author csypc
 * @version 1.0
 */
public class ScheduleTest {
    public static void main(String[] args) throws InterruptedException {

        //创建定时器
        Timer timer = new Timer();

        //安排在指定的时间执行指定的任务。
        timer.schedule(new TimerTask() {
            //TimerTask实现Runnable，定时器任务
            @Override
            public void run() {
                System.out.println("time schedule...");
            }
        },new Date(System.currentTimeMillis()),1000);

        Thread.sleep(1000);

        //终止此计时器，丢弃所有当前已安排的任务。
        timer.cancel();
    }
}
