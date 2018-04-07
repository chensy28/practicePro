package com.csy.tcp.chat.demo3;

import com.csy.tcp.chat.demo2.*;
import com.csy.tcp.chat.demo2.CloseIOUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private DataOutputStream dos;
    private boolean isRunning = true;

    public Send(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    //初始化数据
    public Send(Socket client){
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            com.csy.tcp.chat.demo2.CloseIOUtil.closeAll(reader, dos);//关闭流
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
    public void send(){
        String msg = getMsg();

        try {
            if(msg != null && !msg.equals("")){
                dos.writeUTF(msg);
                dos.flush();
            }

        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseIOUtil.closeAll(reader, dos);//关闭流
        }
    }

    @Override
    public void run() {
        while(isRunning){
            send();
        }
    }
}
