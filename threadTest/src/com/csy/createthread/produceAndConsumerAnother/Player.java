package com.csy.createthread.produceAndConsumerAnother;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������������
 * ����ʱ�䣺2016��03��12�� ����20:54
 *
 * @author csypc
 * @version 1.0
 */
public class Player implements Runnable {
    private Movie movie;

    public Player(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
         for(int i=0;i<2;i++){
             if(0 == i%2){
                 //����������,Ϊ������Դ��ֵ
                 movie.play("������");
             }else{
                 movie.play("�Ұ׻�");
             }
         }
    }
}
