package com.csy.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 项目名称：
 * 类名称： Udp客户端(数据转换，使用流)
 * 类描述：  1) 创建客户端+端口
 *          2) 准备数据
 *          3) 打包（指定服务器端的地址及端口）
 *          4）发送
 *          5）释放
 *
 * 创建时间：2016年03月31日 下午21:17
 *
 * @author csypc
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {

        //创建客户端+端口
        DatagramSocket client = new DatagramSocket(6666);

        //准备数据
        byte [] sendData =  convertToBytes(82.15);
        InetAddress ip = InetAddress.getLocalHost();

        //打包（指定服务器端的地址及端口）
        DatagramPacket packet = new DatagramPacket(sendData,0,sendData.length,ip,8888);
        //发送
        client.send(packet);
        //释放
        client.close();

    }

    public static byte[] convertToBytes(double num) throws IOException {
        byte[] bytes = null;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeDouble(num);

        bytes = bos.toByteArray();
        dos.flush();
        dos.close();
        return bytes;
    }




}
