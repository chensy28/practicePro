package com.csy.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 项目名称：
 * 类名称：
 * 类描述：UDP 服务器端  （数据转换）
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
public class Server {
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

        double d = convertToBasic(datas);
        System.out.println(d);

        server.close();
    }

    public static double convertToBasic(byte []arr) throws IOException {
        double var = 0.0;
        ByteArrayInputStream bis = new ByteArrayInputStream(arr);
        //接口用于从二进制流中读取字节，并根据所有 Java 基本类型数据进行重构。
        DataInputStream dis = new DataInputStream(bis);
        var = dis.readDouble();
        dis.close();
        return var;
    }
}
