package com.csy.tcp.chat.demo3;

import com.csy.tcp.chat.demo2.*;
import com.csy.tcp.chat.demo2.CloseIOUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private DataOutputStream dos;
    private boolean isRunning = true;

    public Send(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    //��ʼ������
    public Send(Socket client){
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            com.csy.tcp.chat.demo2.CloseIOUtil.closeAll(reader, dos);//�ر���
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
    public void send(){
        String msg = getMsg();

        try {
            if(msg != null && !msg.equals("")){
                dos.writeUTF(msg);
                dos.flush();
            }

        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseIOUtil.closeAll(reader, dos);//�ر���
        }
    }

    @Override
    public void run() {
        while(isRunning){
            send();
        }
    }
}
