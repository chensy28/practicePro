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
public class Server6 {

    private ServerSocket serverSocket;
    private boolean isShutDown;

    public static void main(String[] args) {
        Server6 server = new Server6();
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
            while(!isShutDown) {
                new Thread(new Dispatcher(serverSocket.accept())).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
            isShutDown = true;
        }
        return reponse.toString();
    }

    //响应信息
    public void send(){

    }
}
