package com.csy.tcp.chat.demo5;

import java.io.*;
import java.net.Socket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：发送数据线程
 * 创建时间：2016年04月04日 下午22:03
 *
 * @author csypc
 * @version 1.0
 */
public class Send implements Runnable{

    private BufferedReader reader;
    private BufferedWriter writer;
    private boolean isRunning = true;
    private String name;

    public Send(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    //初始化数据
    public Send(Socket client,String name){
        this();
        try {
            writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            this.name = name;
            send(name);

        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            com.csy.tcp.chat.demo5.CloseIOUtil.closeAll(reader, writer);//关闭流
        }
    }

    //接收数据
    public String getMsg(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //发送数据
    public void send(String msg){
        try {
            if(msg != null && !msg.equals("")){
                writer.write(msg);
                writer.newLine();//bufferedwriter流写出内容时，需要加入换行符标记
                writer.flush();
            }

        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseIOUtil.closeAll(reader, writer);//关闭流
        }
    }

    @Override
    public void run() {
        while(isRunning){
            send(getMsg());
        }
    }
}
