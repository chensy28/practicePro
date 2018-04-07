package com.csy.tcp.chat.demo2;

import java.io.DataInputStream;
import java.io.IOException;
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
    private DataInputStream dis;
    private boolean isRunning = true;

    public Receive(){

    }

    //初始化数据
    public Receive(Socket client){
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseIOUtil.closeAll(dis);
        }
    }

    //接收数据
    public String getMsg(){
        String msg = "";
        try {
            msg = dis.readUTF();
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
            System.out.println("客服端接收:"+msg);
        }
    }
}
