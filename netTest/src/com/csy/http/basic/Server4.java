package com.csy.http.basic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：服务器（封装response）
 * 创建时间：2016年04月06日 下午08:45
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

    //启动服务
    public void start(){
        try {
            serverSocket = new ServerSocket(8890);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //接收信息
    public String receive(){
        StringBuilder reponse = new StringBuilder();
        try {
            //监听并接受到此套接字的连接。
            Socket socket = serverSocket.accept();

            String msg = "";
            //读取客户端信息（post形式）
            byte []info = new byte[20480];
            int len = socket.getInputStream().read(info);

            System.out.println("客户端请求信息:\n"+new String(info,0,len).trim());

            Response response = new Response(socket.getOutputStream());
            response.createHead(200);
            String context = "<html><head><title>response响应封装</title></head><p>封装response </p></html>";
            response.print(context);
            response.setLen(context.getBytes().length);
            response.pushToClient();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return reponse.toString();
    }

    //响应信息
    public void send(){

    }
}
