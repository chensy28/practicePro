package com.csy.tcp.basic;

import java.io.*;
import java.net.Socket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��04��03�� ����17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //�����ͻ��ˣ������ƶ������+�˿ڣ���ʱ��������
        Socket socket = new Socket("localhost",8889);

        byte []arr = new byte[1024];
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        int len = bis.read(arr);
        System.out.println("Client��"+new String(arr,0,len));
/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = reader.readLine();//����ʽ��������û�ж������ݻᱨ�쳣*/

        //ʹ��������������
        /*DataInputStream in = new DataInputStream(socket.getInputStream());
        String msg = in.readUTF();
        System.out.println(msg);*/
    }
}
