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

        //�����߳�
        robbit.start();
        dog.start();
        //��ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������߳�
        //Robbit.yield();

        //�����߳����ȼ�
        /*robbit.setPriority(Thread.MAX_PRIORITY);
        tortoise.start();
        tortoise.setPriority(Thread.MIN_PRIORITY);*/
        /* dog.start();*/

        //����Ҫ�ֶ�����run������ֻҪ����start���������󣬽����ڲ�����
        /*robbit.run();
        tortoise.run();*/

        //���ص�ǰ�̵߳��߳����л�̵߳���Ŀ
       // System.out.println("active:" + Robbit.activeCount());
        /*robbit.destroy();*/

        //���ظ��̵߳ı�ʶ��   ---- 11:12
        //System.out.println(robbit.getId()+":"+ tortoise.getId());
        //���ظ��̵߳�����   ----- Thread-0 Thread-1
       // System.out.println(robbit.getName() + " " + tortoise.getName());

        //java�����ȼ���1��10�����ȼ�Խ�󣬾�Խ��ִ��
        //System.out.print(robbit.getPriority()+ " " + tortoise.getPriority());

       // ���ظ��̵߳�״̬�� �÷������ڼ���ϵͳ״̬��������ͬ�����ơ�  ----- RUNNABLE TERMINATED
      /*  try {
            robbit.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.State state = robbit.getState();
        System.out.print(state);*/

        //���ظ��߳��������߳��顣   ---- main
       /* ThreadGroup threadGroup = robbit.getThreadGroup();
        System.out.print(threadGroup.getName());*/

        /*//�ж��̡߳�
        robbit.interrupt();
        //���Ե�ǰ�߳��Ƿ��Ѿ��жϡ�
        System.out.println(robbit.isInterrupted());
        //�����߳��Ƿ��ڻ״̬��
        System.out.print(robbit.isAlive());*/

        //���Ը��߳��Ƿ�Ϊ�ػ��̡߳�
        //System.out.print(robbit.isDaemon());

    }
}
