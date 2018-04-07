package com.csy.createthread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：sleep模拟倒计时
 * 创建时间：2016年03月09日 下午23:09
 *
 * @author csypc
 * @version 1.0
 */
public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        /*//倒数10个数
        int num = 10;
        boolean flag= true;
        while(flag){
            System.out.println(num--);
            //让当前线程休眠，不释放锁
            Thread.sleep(1000);
            if(num<=0){
                break;
            }
        }*/

        //倒计时
        Date endTime = new Date(System.currentTimeMillis());
        Long end = endTime.getTime();
        while(true){
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(endTime));
            Thread.sleep(1000);
            //时间的下一秒（更新时间）
            endTime = new Date(endTime.getTime()-1000);
            //定义循环的边界
            if(end - 10*1000 > endTime.getTime()){
                   break;
            }
        }


    }
}
