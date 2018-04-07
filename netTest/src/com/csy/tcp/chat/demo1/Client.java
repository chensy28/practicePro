package com.csy.tcp.chat.demo1;

import java.io.*;
import java.net.Socket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������ʵ�ֿͻ�����������Ľ���
 * ����ʱ�䣺2016��04��03�� ����17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //�����ͻ��ˣ������ƶ������+�˿ڣ���ʱ��������
        Socket socket = new Socket("localhost",8888);

        //��������
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("�ͻ�������--->");
        writer.newLine();
        writer.flush();

        //��������
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = reader.readLine();//����ʽ��������û�ж������ݻᱨ�쳣
        System.out.println(msg);
    }
}
