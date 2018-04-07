package com.csy.udp;

import java.io.IOException;
import java.net.*;

/**
 * 项目名称：
 * 类名称： Udp客户端（和服务器端用同样的类）
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
public class UdpClient {
    public static void main(String[] args) throws IOException {

        //创建客户端+端口
        DatagramSocket client = new DatagramSocket(6666);

        //准备数据
        String str = "hello server!";
        byte [] sendData = str.getBytes();
        InetAddress ip = InetAddress.getLocalHost();

        //打包（指定服务器端的地址及端口）
        DatagramPacket packet = new DatagramPacket(sendData,0,sendData.length,ip,8888);
        //发送
        client.send(packet);
        //释放
        client.close();
    }
}
