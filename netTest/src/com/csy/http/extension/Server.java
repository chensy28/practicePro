package com.csy.http.extension;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：服务器（封装response）
 * 创建时间：2016年04月06日 下午08:45
 *
 * @author csypc
 * @version 1.0
 */
public class Server {

    private ServerSocket serverSocket;
    private boolean isShutDown;

    public static void main(String[] args) {
        Server server = new Server();
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
                Thread thread = new Thread(new Dispatcher(serverSocket.accept()));
                thread.setName("servlet");
                thread.start();
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
