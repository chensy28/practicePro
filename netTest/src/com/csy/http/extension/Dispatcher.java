package com.csy.http.extension;

import java.io.IOException;
import java.net.Socket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：调度器
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
            //解析内容
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
            //根据url确定执行哪个servlet
            Servlet servlet = WebApp.getServlet(request.getUrl());
            if(null == servlet){
                code = 404; //请求找不到
                response.setCode(404);
            }else {
                //调用servlet中方法处理
                servlet.service(request, response);
                response.setCode(200);
            }

        }catch (Exception e){
            code = 500;
            response.setCode(500);
        }
        response.pushToClient();

        //关闭socket

    }
}
