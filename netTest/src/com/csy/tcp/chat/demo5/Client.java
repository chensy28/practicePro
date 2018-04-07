package com.csy.tcp.chat.demo5;

import java.io.*;
import java.net.Socket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：私聊
 * 创建时间：2016年04月03日 下午17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端，必须制定服务端+端口，此时就在连接
        Socket socket = new Socket("localhost",8889);

        System.out.println("请输入名称：");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        //发送数据
        new Thread(new Send(socket,name)).start();
        //接收数据
        new Thread(new Receive(socket)).start();
    }
}
