package com.csy.createthread;


/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：线程阻塞
 * 创建时间：2016年03月08日 下午22:10
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadJoin extends Thread{
    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();//真实角色
        Thread t = new Thread(threadJoin);//新生状态（代理角色）
        t.start();//就绪状态
        System.out.println("线程名："+t.getName()+"线程数:"+Thread.activeCount());  //3个线程（包含主线程）
        System.out.println("当前线程："+Thread.currentThread());
        //多个线程cpu分配的时间片中交替进行
        for(int i=0;i<1000;i++){
           if(50 == i){
                //t.join();//在i等于50之前，线程交互进行，等于50之后，将线程合并为一条路径
               t.join(10);//等待该线程终止的时间最长为 millis 毫秒,超过指定时间，就不在阻塞  main阻塞
            }
            //t.join();//将路径合并一条，合并后一条路径执行完了，再执行另一条
            System.out.println("main-->"+i);
        }
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("join-->"+i);
        }
    }
}
