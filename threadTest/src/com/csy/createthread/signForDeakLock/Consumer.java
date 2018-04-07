package com.csy.createthread.signForDeakLock;

/**
 * 项目名称：
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月13日 下午12:09
 *
 * @author csypc
 * @version 1.0
 */
public class Consumer implements Runnable{

    private HandSide handSide;

    public Consumer(HandSide handSide) {
        this.handSide = handSide;
    }

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            handSide.eatNoodel(i);
        }
    }
}
