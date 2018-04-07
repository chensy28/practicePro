package com.csy.tcp.chat.demo1;

import java.io.*;
import java.net.Socket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：实现客户端与服务器的交互
 * 创建时间：2016年04月03日 下午17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端，必须制定服务端+端口，此时就在连接
        Socket socket = new Socket("localhost",8888);

        //发送数据
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("客户端数据--->");
        writer.newLine();
        writer.flush();

        //接收数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = reader.readLine();//阻塞式方法，若没有读到数据会报异常
        System.out.println(msg);
    }
}
