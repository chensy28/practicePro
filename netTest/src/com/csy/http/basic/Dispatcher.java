package com.csy.http.basic;

import java.io.IOException;
import java.net.Socket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：
 * 创建时间：2016年04月12日 下午21:40
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
            response = new Response(client.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            code = 500;
            return;
        }

    }

    @Override
    public void run() {
        Servlet servlet = new Servlet();
        servlet.service(request,response);
        response.pushToClient();

        //关闭socket

    }
}
