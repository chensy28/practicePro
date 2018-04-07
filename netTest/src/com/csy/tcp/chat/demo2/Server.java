package com.csy.tcp.chat.demo2;

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
        ServerSocket serverSocket = new ServerSocket(8889);

        //接收客户端连接、阻塞式的（获取到通信通道）
        Socket socket = serverSocket.accept();

        //接收数据 (客户端用什么流输出数据，服务器端需要与之对应)
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        //循环读取
        while(true) {
            String msg = dis.readUTF();//阻塞式方法，若没有读到数据会报异常
            System.out.println("服务端接收数据" + msg);

            //发送数据
            dos.writeUTF(msg);
            dos.flush();
        }

    }
 }
