package com.csy.createthread;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：停止线程(自定义方法 ：外部干涉)
 * 创建时间：2016年03月08日 下午21:32
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadStop {
    public static void main(String[] args) {
        //由于Thread类中提供的stop方法过时了，不安全所有自定义法停止线程的方法
        Study study = new Study();
        Thread thread = new Thread(study);
        thread.start();
        for(int i=0;i<100;i++){
            if(50 == i){
                study.stop();
            }
            System.out.println("main....."+i);
        }

    }
}

class Study implements Runnable{

    //定义线程体使用的标志
    private boolean flag = true;
    @Override
    public void run() {
        //使用标志
        while(flag){
            System.out.println("Thread start ！");
        }
    }

    //对外提供改变标志的方法
    public void stop(){
        this.flag = false;
    }
}
