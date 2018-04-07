package com.csy.http.basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 项目名称：
 * 类名称：
 * 类描述：服务器（手写HttpServer服务器响应）
 * 创建时间：2016年04月06日 下午08:45
 *
 * @author csypc
 * @version 1.0
 */
public class Server3 {

    private ServerSocket serverSocket;

    //行结束符与回车符
    public static String CRLF = "\r\n";
    public static String BLANK = " ";//空行

    public static void main(String[] args) {
        Server3 server = new Server3();
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

            String context = "<html><head><title>http响应</title></head><p>hello! how are you ? </p></html>";

            //Http协议版本、状态代码、描述
            reponse.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("ok").append(CRLF);
            //响应头
            reponse.append("Server:csy").append(BLANK).append("Server/0.0.1").append(CRLF);
            reponse.append("Date:").append(new Date()).append(CRLF);
            //响应的格式
            reponse.append("Context-type:text/html;charset-GBK").append(CRLF);
            //响应的字节数
            reponse.append("Context-Length:").append(context.toString().getBytes().length).append(CRLF);

            //响应正文前
            reponse.append(CRLF);
            //响应正文
            reponse.append(context);

            //写到流中
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(reponse.toString());
            writer.flush();
            writer.close();
            System.out.println("服务端响应\n"+reponse.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return reponse.toString();
    }

    //响应信息
    public void send(){

    }
}
