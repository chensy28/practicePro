package com.csy.http.perfect;

import java.io.IOException;
import java.net.Socket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������������
 * ����ʱ�䣺2016��04��12�� ����21:40
 *
 * @author csypc
 * @version 1.0
 */
public class Dispatcher implements Runnable{
    private Request request;
    private Response response;
    private Socket client;
    private int code = 200;
    public Dispatcher(Socket client){
        this.client = client;
        try {
            request = new Request(client.getInputStream());
            //��������
            request.parse();
            response = new Response(client.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            code = 500;
            return;
        }

    }

    @Override
    public void run() {
        try {
            //����urlȷ��ִ���ĸ�servlet
            Servlet servlet = WebApp.getServlet(request.getUrl());
            if(null == servlet){
                code = 404; //�����Ҳ���
                response.setCode(404);
            }else {
                //����servlet�з�������
                servlet.service(request, response);
                response.setCode(200);
            }

        }catch (Exception e){
            code = 500;
            response.setCode(500);
        }
        response.pushToClient();

        //�ر�socket

    }
}
