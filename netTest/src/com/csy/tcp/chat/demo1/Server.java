package com.csy.tcp.chat.demo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ���������������ˣ������뷢�Ͳ�Ӧ�����Ⱥ�˳��Ӧ�÷����߳��У�
 * ����ʱ�䣺2016��04��03�� ����17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //�����������ˣ��ƶ��˿�
        ServerSocket serverSocket = new ServerSocket(8888);

        //���տͻ������ӡ�����ʽ�ģ���ȡ��ͨ��ͨ����
        Socket socket = serverSocket.accept();

        //��������
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = reader.readLine();//����ʽ��������û�ж������ݻᱨ�쳣
        System.out.println(msg);

        //��������
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("���������--->");
        writer.newLine();
        writer.flush();


    }


}
