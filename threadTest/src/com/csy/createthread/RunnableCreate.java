package com.csy.createthread;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月07日 下午08:56
 *
 * @author csypc
 * @version 1.0
 */
public class RunnableCreate implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        //真实角色
        RunnableCreate create = new RunnableCreate();
        //代理角色
        Thread thread = new Thread(create);
        thread.start();
    }
}
