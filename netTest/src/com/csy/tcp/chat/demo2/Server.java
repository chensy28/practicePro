package com.csy.tcp.chat.demo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������������
 * ����ʱ�䣺2016��04��03�� ����17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //�����������ˣ��ƶ��˿�
        ServerSocket serverSocket = new ServerSocket(8889);

        //���տͻ������ӡ�����ʽ�ģ���ȡ��ͨ��ͨ����
        Socket socket = serverSocket.accept();

        //�������� (�ͻ�����ʲô��������ݣ�����������Ҫ��֮��Ӧ)
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        //ѭ����ȡ
        while(true) {
            String msg = dis.readUTF();//����ʽ��������û�ж������ݻᱨ�쳣
            System.out.println("����˽�������" + msg);

            //��������
            dos.writeUTF(msg);
            dos.flush();
        }

    }
 }
