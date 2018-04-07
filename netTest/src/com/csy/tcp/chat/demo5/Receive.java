package com.csy.tcp.chat.demo5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * �����������������߳�
 * ����ʱ�䣺2016��04��04�� ����22:02
 *
 * @author csypc
 * @version 1.0
 */
public class Receive implements Runnable{
    private BufferedReader dis;
    private boolean isRunning = true;

    public Receive(){

    }

    //��ʼ������
    public Receive(Socket client){
        try {
            dis = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            com.csy.tcp.chat.demo3.CloseIOUtil.closeAll(dis);
        }
    }

    //��������
    public String getMsg(){
        String msg = "dgdfdfdf";
        try {
            msg = dis.readLine();
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseIOUtil.closeAll(dis);
        }
        return msg;
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = getMsg();
            System.out.println(msg);
        }
    }
}
