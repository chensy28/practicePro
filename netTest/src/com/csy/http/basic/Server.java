package com.csy.http.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：服务器（接收get请求）
 * 创建时间：2016年04月06日 下午08:45
 *
 * @author csypc
 * @version 1.0
 */
public class Server {

    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server server = new Server();
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
        try {
            //监听并接受到此套接字的连接。
            Socket socket = serverSocket.accept();

            StringBuilder builder = new StringBuilder();
            String msg = "";
            //读取客户端信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while((msg = reader.readLine()).length() > 0){
                  builder.append(msg);
                  builder.append("\n");
            }

            if(!builder.toString().equals("")){
                System.out.println("客户端请求信息:\n"+builder.toString().trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //响应信息
    public void send(){

    }
}
