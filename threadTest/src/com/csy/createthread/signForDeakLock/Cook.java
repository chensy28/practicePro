package com.csy.createthread.signForDeakLock;

/**
 * 项目名称：
 * 类名称：
 * 类描述：厨师（生产者）
 * 创建时间：2016年03月13日 下午12:08
 *
 * @author csypc
 * @version 1.0
 */
public class Cook implements Runnable  {

    private HandSide handSide;

    public Cook(HandSide handSide) {
        this.handSide = handSide;
    }

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            //调用公有资源的方法
            handSide.doNoodle("手工面",i);
        }
    }
}
