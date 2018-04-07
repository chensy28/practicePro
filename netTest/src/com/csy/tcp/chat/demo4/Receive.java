package com.csy.tcp.chat.demo4;

import com.csy.tcp.chat.demo2.CloseIOUtil;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：接收数据线程
 * 创建时间：2016年04月04日 下午22:02
 *
 * @author csypc
 * @version 1.0
 */
public class Receive implements Runnable{
    private BufferedReader dis;
    private boolean isRunning = true;

    public Receive(){

    }

    //初始化数据
    public Receive(Socket client){
        try {
            dis = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            com.csy.tcp.chat.demo3.CloseIOUtil.closeAll(dis);
        }
    }

    //接收数据
    public String getMsg(){
        String msg = "dgdfdfdf";
        try {
            msg = dis.readLine();
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseIOUtil.closeAll(dis);
        }
        return msg;
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = getMsg();
            System.out.println(msg);
        }
    }
}
