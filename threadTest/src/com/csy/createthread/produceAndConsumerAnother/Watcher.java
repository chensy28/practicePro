package com.csy.createthread.produceAndConsumerAnother;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������������
 * ����ʱ�䣺2016��03��12�� ����20:55
 *
 * @author csypc
 * @version 1.0
 */
public class Watcher implements Runnable {
    private Movie movie;

    public Watcher(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for(int i=0;i<2;i++) {
            //����������,���ѹ�����Դ
           movie.watch();
        }
    }
}
