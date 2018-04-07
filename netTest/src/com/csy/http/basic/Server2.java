package com.csy.http.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������������������post����
 * ����ʱ�䣺2016��04��06�� ����08:45
 *
 * @author csypc
 * @version 1.0
 */
public class Server2 {

    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server2 server = new Server2();
        server.start();
        server.receive();
    }

    //��������
    public void start(){
        try {
            serverSocket = new ServerSocket(8890);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //������Ϣ
    public String receive(){
        try {
            //���������ܵ����׽��ֵ����ӡ�
            Socket socket = serverSocket.accept();

            String msg = "";
            //��ȡ�ͻ�����Ϣ��post��ʽ��
            byte []info = new byte[20480];

            int len = socket.getInputStream().read(info);
            System.out.println("�ͻ���������Ϣ:\n"+new String(info,0,len).trim());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //��Ӧ��Ϣ
    public void send(){

    }
}
