package com.csy.tcp.chat.demo2;

import java.io.*;
import java.net.Socket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * �����������ͻ��˵�������������ڶ���߳���
 * ����ʱ�䣺2016��04��03�� ����17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //�����ͻ��ˣ������ƶ������+�˿ڣ���ʱ��������
        Socket socket = new Socket("localhost",8889);

        //��������
        new Thread(new Send(socket)).start();
        //��������
        new Thread(new Receive(socket)).start();
    }
}
