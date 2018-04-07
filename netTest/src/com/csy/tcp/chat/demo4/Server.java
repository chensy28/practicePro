package com.csy.tcp.chat.demo4;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


/**
 * 项目名称：
 * 类名称：
 * 类描述：服务器端(加入线程，使得服务端可以处理多个客户端数据,读取或输出没有先后顺序)
 * 创建时间：2016年04月03日 下午17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Server {
    //用来管理所有的客户端
    private List<MyChannel> all = new ArrayList<MyChannel>();


    public static void main(String[] args) throws IOException {
       new Server().startRun();
    }

    public void startRun() throws IOException {
        //创建服务器端，制定端口
        ServerSocket serverSocket = new ServerSocket(8889);
        //循环读取
        while(true) {
            //接收客户端连接、阻塞式的（获取到通信通道）
            Socket socket = serverSocket.accept();
            MyChannel myChannel = new MyChannel(socket);

            new Thread(myChannel).start();
            all.add(myChannel);//管理客户端
        }
    }

    /**
     *
     * 一个客户端，一条道路
     * 1.输入流
     * 2.输出流
     * 3.接收数据
     * 4.发送数据
     */
    private class MyChannel implements Runnable{

        private BufferedReader br;
        private BufferedWriter bw;
        private boolean isRunning = true;
        private String name;

        public MyChannel(Socket socket){

            try {
                //输入、输出流要对应使用
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                this.name = br.readLine();
                System.out.println(name);

                send("欢迎你进入聊天室");
                sendOther(name+"进入了聊天室");

            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                com.csy.tcp.chat.demo4.CloseIOUtil.closeAll(br, bw);
            }

        }

        //接收数据
        public String receive(){
            String msg = "";
            try {
                 msg = br.readLine();
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                com.csy.tcp.chat.demo3.CloseIOUtil.closeAll(br);
                all.remove(this);//出现异常，移除自身
            }
            return msg;
        }

        //发送数据
        public void send(String msg){
            //若内容为空，则不发送
            if(msg == null || msg.equals("")){
                return ;
            }

            try {
                bw.write(msg);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                CloseIOUtil.closeAll(bw);
                all.remove(this);//出现异常，移除自身
            }
        }

        //发送给其它客户端
        public void sendOther(String msg){
            for(MyChannel other : all){
                if(other == this){
                    continue;
                }
                other.send(msg);
            }
        }

        @Override
        public void run() {
            while(isRunning){
                sendOther(receive());//转发给其它客户端
            }
        }
    }
 }
