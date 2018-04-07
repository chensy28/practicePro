package com.csy.pipedtest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ���������ܵ�������Ӧ�����ӵ��ܵ���������ܵ��������ṩҪд��ܵ�����������������ֽڡ�
 *          �������������������ʹ�õ����̣߳���Ϊ�������������̡߳�
 * ����ʱ�䣺2016��03��23�� ����08:18
 *
 * @author csypc
 * @version 1.0
 */
public class PipedStreamTest {
    public static void main(String[] args) {
        //��Java�У�����ʹ�ùܵ��������߳�֮���ͨ��
        PipedReader reader = new PipedReader();
        PipedSender sender = new PipedSender();

        PipedOutputStream out = new PipedSender().getOut();
        PipedInputStream in = new PipedReader().getIn();

        //���ܵ���������
        try {
            in.connect(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //�����̣߳������ݽ��ж�ȡ��д��
        reader.start();
        sender.start();                       //�˳����׳�java.io.IOException: Pipe not connected
    }
}
