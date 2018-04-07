package com.csy.http.basic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ������������������װresponse��
 * ����ʱ�䣺2016��04��06�� ����08:45
 *
 * @author csypc
 * @version 1.0
 */
public class Server5 {

    private ServerSocket serverSocket;


    public static void main(String[] args) {
        Server5 server = new Server5();
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
            //���������ܵ����׽��ֵ����ӡ�
            Socket socket = serverSocket.accept();

            Request request = new Request(socket.getInputStream());
            request.parse();

            Response response = new Response(socket.getOutputStream());
            response.createHead(200);
            String context = "<html><head><title>response��Ӧ��װ</title></head>";
            response.print(context);
            //����
            String hello = "�����";
            String encodeStr = URLEncoder.encode(hello,"gbk");
            response.print(encodeStr);

            //����
            String decoderStr = URLDecoder.decode(request.getValue("uname"), "gbk");
            response.print("��ӭ��"+ decoderStr);
            response.print("</html>");

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
