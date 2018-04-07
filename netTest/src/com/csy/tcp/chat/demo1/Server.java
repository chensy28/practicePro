package com.csy.tcp.chat.demo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：服务器端（接收与发送不应该有先后顺序，应该放在线程中）
 * 创建时间：2016年04月03日 下午17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器端，制定端口
        ServerSocket serverSocket = new ServerSocket(8888);

        //接收客户端连接、阻塞式的（获取到通信通道）
        Socket socket = serverSocket.accept();

        //接收数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = reader.readLine();//阻塞式方法，若没有读到数据会报异常
        System.out.println(msg);

        //发送数据
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("服务端数据--->");
        writer.newLine();
        writer.flush();


    }


}
