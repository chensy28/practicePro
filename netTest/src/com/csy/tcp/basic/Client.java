package com.csy.tcp.basic;

import java.io.*;
import java.net.Socket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：
 * 创建时间：2016年04月03日 下午17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端，必须制定服务端+端口，此时就在连接
        Socket socket = new Socket("localhost",8889);

        byte []arr = new byte[1024];
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        int len = bis.read(arr);
        System.out.println("Client："+new String(arr,0,len));
/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = reader.readLine();//阻塞式方法，若没有读到数据会报异常*/

        //使用数据输入流读
        /*DataInputStream in = new DataInputStream(socket.getInputStream());
        String msg = in.readUTF();
        System.out.println(msg);*/
    }
}
