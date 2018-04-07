package com.csy.http.extension;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ������������������װresponse��
 * ����ʱ�䣺2016��04��06�� ����08:45
 *
 * @author csypc
 * @version 1.0
 */
public class Server {

    private ServerSocket serverSocket;
    private boolean isShutDown;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
        server.receive();
    }

    //��������
    public void start(){
        try {
            serverSocket = new ServerSocket(8887);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //������Ϣ
    public String receive(){
        StringBuilder reponse = new StringBuilder();
        try {
            while(!isShutDown) {
                Thread thread = new Thread(new Dispatcher(serverSocket.accept()));
                thread.setName("servlet");
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
            isShutDown = true;
        }
        return reponse.toString();
    }

    //��Ӧ��Ϣ
    public void send(){

    }
}
