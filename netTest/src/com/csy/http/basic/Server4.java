package com.csy.http.basic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ������������������װresponse��
 * ����ʱ�䣺2016��04��06�� ����08:45
 *
 * @author csypc
 * @version 1.0
 */
public class Server4 {

    private ServerSocket serverSocket;


    public static void main(String[] args) {
        Server4 server = new Server4();
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
        StringBuilder reponse = new StringBuilder();
        try {
            //���������ܵ����׽��ֵ����ӡ�
            Socket socket = serverSocket.accept();

            String msg = "";
            //��ȡ�ͻ�����Ϣ��post��ʽ��
            byte []info = new byte[20480];
            int len = socket.getInputStream().read(info);

            System.out.println("�ͻ���������Ϣ:\n"+new String(info,0,len).trim());

            Response response = new Response(socket.getOutputStream());
            response.createHead(200);
            String context = "<html><head><title>response��Ӧ��װ</title></head><p>��װresponse </p></html>";
            response.print(context);
            response.setLen(context.getBytes().length);
            response.pushToClient();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return reponse.toString();
    }

    //��Ӧ��Ϣ
    public void send(){

    }
}
