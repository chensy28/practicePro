package com.csy.http.basic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 项目名称：
 * 类名称：
 * 类描述：服务器（封装response）
 * 创建时间：2016年04月06日 下午08:45
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

    //启动服务
    public void start(){
        try {
            serverSocket = new ServerSocket(8887);
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

            Request request = new Request(socket.getInputStream());
            request.parse();

            Response response = new Response(socket.getOutputStream());
            response.createHead(200);
            String context = "<html><head><title>response响应封装</title></head>";
            response.print(context);
            //编码
            String hello = "你好吗";
            String encodeStr = URLEncoder.encode(hello,"gbk");
            response.print(encodeStr);

            //解码
            String decoderStr = URLDecoder.decode(request.getValue("uname"), "gbk");
            response.print("欢迎："+ decoderStr);
            response.print("</html>");

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
