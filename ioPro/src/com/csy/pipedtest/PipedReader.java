package com.csy.pipedtest;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��23�� ����08:00
 *
 * @author csypc
 * @version 1.0
 */
public class PipedReader extends Thread{
    private PipedInputStream in = new PipedInputStream();

    public PipedInputStream getIn(){
        return in;
    }

    @Override
    public void run() {
         byte []buf = new byte[1024];
        try {
            int len = in.read(buf);
            System.out.println("data from sender:");
            System.out.println(new String(buf,0,len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
