package com.csy.tcp.basic;

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
        ServerSocket serverSocket = new ServerSocket(8888);

        //���տͻ������ӡ�����ʽ�ģ���ȡ��ͨ��ͨ����
        Socket socket = serverSocket.accept();

        //��������
        String msg = "��ã�hello";

        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
        out.write(msg.getBytes());
        out.flush();

        //ʹ�û��������BufferedWriter
        /*BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(msg);
        writer.newLine();// д��һ���зָ��������ô˷�������ֹÿ�������
        writer.flush();// ˢ�¸����Ļ���,������д��Ŀ���豸*/

        //ʹ�����������DataOutputStream
       /* DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(msg);
        out.flush();*/

        System.out.println("�ͻ���kddl����");//��ӡ�����Լ��ͻ����Ƿ��������������
    }
}
