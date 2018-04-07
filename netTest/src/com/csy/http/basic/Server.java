package com.csy.http.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������������������get����
 * ����ʱ�䣺2016��04��06�� ����08:45
 *
 * @author csypc
 * @version 1.0
 */
public class Server {

    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server server = new Server();
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

            StringBuilder builder = new StringBuilder();
            String msg = "";
            //��ȡ�ͻ�����Ϣ
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while((msg = reader.readLine()).length() > 0){
                  builder.append(msg);
                  builder.append("\n");
            }

            if(!builder.toString().equals("")){
                System.out.println("�ͻ���������Ϣ:\n"+builder.toString().trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //��Ӧ��Ϣ
    public void send(){

    }
}
