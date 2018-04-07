package com.csy.tcp.chat.demo2;

import java.io.DataInputStream;
import java.io.IOException;
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
    private DataInputStream dis;
    private boolean isRunning = true;

    public Receive(){

    }

    //��ʼ������
    public Receive(Socket client){
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseIOUtil.closeAll(dis);
        }
    }

    //��������
    public String getMsg(){
        String msg = "";
        try {
            msg = dis.readUTF();
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
            System.out.println("�ͷ��˽���:"+msg);
        }
    }
}
