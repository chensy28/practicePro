package com.csy.createthread;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：使用yield阻塞线程
 * 创建时间：2016年03月08日 下午23:13
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadYield extends ThreadJoin{
    public static void main(String[] args) {  //main线程的线程体
        ThreadYield threadJoin = new ThreadYield();//真实角色
        Thread t = new Thread(threadJoin);//新生状态（代理角色）
        t.start();//就绪状态
        for(int i=0;i<1000;i++){
            if(i % 20 == 0){
                Thread.yield();//暂停当前线程main,写在哪个线程体，就暂停哪个线程
            }
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
