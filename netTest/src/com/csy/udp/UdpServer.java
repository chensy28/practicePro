package com.csy.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：UDP 服务器端
 *         1）创建服务器+端口
 *         2)准备接收的容器
 *         3）封装成包
 *         4)接收数据
 *         5）分析数据
 *         6）释放资源
 *
 * 创建时间：2016年03月31日 下午21:00
 *
 * @author csypc
 * @version 1.0
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {

        //创建服务器+端口
        DatagramSocket server = new DatagramSocket(8888);
        //准备接收的容器
        byte [] buf = new byte[1024];
        //封装成包
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        //接收数据
        server.receive(packet);
        //分析数据
        byte [] datas = packet.getData();
        int len = datas.length;
        System.out.println(new String(datas,0,len));
        //释放资源
        server.close();
    }
}
