package com.csy.tcp.basic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：服务器端
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

        //发送数据
        String msg = "你好！hello";

        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
        out.write(msg.getBytes());
        out.flush();

        //使用缓冲输出流BufferedWriter
        /*BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(msg);
        writer.newLine();// 写入一个行分隔符，调用此方法来终止每个输出行
        writer.flush();// 刷新该流的缓冲,将数据写到目标设备*/

        //使用数据输出流DataOutputStream
       /* DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(msg);
        out.flush();*/

        System.out.println("客户端kddl连接");//打印语句可以检测客户端是否与服务器端相连
    }
}
