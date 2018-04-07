package com.csy.createthread;



/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/12/23.
 * Time:22:25.
 */
public class ThreadCreate {
    public static void main(String[] args) {
        Robbit robbit = new Robbit();
        Tortoise tortoise = new Tortoise();
        Dog dog = new Dog();

        //启用线程
        robbit.start();
        dog.start();
        //暂停当前正在执行的线程对象，并执行其他线程
        //Robbit.yield();

        //设置线程优先级
        /*robbit.setPriority(Thread.MAX_PRIORITY);
        tortoise.start();
        tortoise.setPriority(Thread.MIN_PRIORITY);*/
        /* dog.start();*/

        //不需要手动调用run方法，只要调用start（）方法后，交由内部调用
        /*robbit.run();
        tortoise.run();*/

        //返回当前线程的线程组中活动线程的数目
       // System.out.println("active:" + Robbit.activeCount());
        /*robbit.destroy();*/

        //返回该线程的标识符   ---- 11:12
        //System.out.println(robbit.getId()+":"+ tortoise.getId());
        //返回该线程的名称   ----- Thread-0 Thread-1
       // System.out.println(robbit.getName() + " " + tortoise.getName());

        //java的优先级由1到10，优先级越大，就越先执行
        //System.out.print(robbit.getPriority()+ " " + tortoise.getPriority());

       // 返回该线程的状态。 该方法用于监视系统状态，不用于同步控制。  ----- RUNNABLE TERMINATED
      /*  try {
            robbit.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.State state = robbit.getState();
        System.out.print(state);*/

        //返回该线程所属的线程组。   ---- main
       /* ThreadGroup threadGroup = robbit.getThreadGroup();
        System.out.print(threadGroup.getName());*/

        /*//中断线程。
        robbit.interrupt();
        //测试当前线程是否已经中断。
        System.out.println(robbit.isInterrupted());
        //测试线程是否处于活动状态。
        System.out.print(robbit.isAlive());*/

        //测试该线程是否为守护线程。
        //System.out.print(robbit.isDaemon());

    }
}
