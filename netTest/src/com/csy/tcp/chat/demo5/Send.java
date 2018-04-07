package com.csy.tcp.chat.demo5;

import java.io.*;
import java.net.Socket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * �����������������߳�
 * ����ʱ�䣺2016��04��04�� ����22:03
 *
 * @author csypc
 * @version 1.0
 */
public class Send implements Runnable{

    private BufferedReader reader;
    private BufferedWriter writer;
    private boolean isRunning = true;
    private String name;

    public Send(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    //��ʼ������
    public Send(Socket client,String name){
        this();
        try {
            writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            this.name = name;
            send(name);

        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            com.csy.tcp.chat.demo5.CloseIOUtil.closeAll(reader, writer);//�ر���
        }
    }

    //��������
    public String getMsg(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //��������
    public void send(String msg){
        try {
            if(msg != null && !msg.equals("")){
                writer.write(msg);
                writer.newLine();//bufferedwriter��д������ʱ����Ҫ���뻻�з����
                writer.flush();
            }

        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseIOUtil.closeAll(reader, writer);//�ر���
        }
    }

    @Override
    public void run() {
        while(isRunning){
            send(getMsg());
        }
    }
}
