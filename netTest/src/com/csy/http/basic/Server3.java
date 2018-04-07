package com.csy.http.basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ������������������дHttpServer��������Ӧ��
 * ����ʱ�䣺2016��04��06�� ����08:45
 *
 * @author csypc
 * @version 1.0
 */
public class Server3 {

    private ServerSocket serverSocket;

    //�н�������س���
    public static String CRLF = "\r\n";
    public static String BLANK = " ";//����

    public static void main(String[] args) {
        Server3 server = new Server3();
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

            String context = "<html><head><title>http��Ӧ</title></head><p>hello! how are you ? </p></html>";

            //HttpЭ��汾��״̬���롢����
            reponse.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("ok").append(CRLF);
            //��Ӧͷ
            reponse.append("Server:csy").append(BLANK).append("Server/0.0.1").append(CRLF);
            reponse.append("Date:").append(new Date()).append(CRLF);
            //��Ӧ�ĸ�ʽ
            reponse.append("Context-type:text/html;charset-GBK").append(CRLF);
            //��Ӧ���ֽ���
            reponse.append("Context-Length:").append(context.toString().getBytes().length).append(CRLF);

            //��Ӧ����ǰ
            reponse.append(CRLF);
            //��Ӧ����
            reponse.append(context);

            //д������
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(reponse.toString());
            writer.flush();
            writer.close();
            System.out.println("�������Ӧ\n"+reponse.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return reponse.toString();
    }

    //��Ӧ��Ϣ
    public void send(){

    }
}
