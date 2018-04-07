package com.csy.basic;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 项目名称：
 * 类名称：
 * 类描述：此类实现 IP 套接字地址（IP 地址 + 端口号）
 * 创建时间：2016年03月29日 下午08:53
 *
 * @author csypc
 * @version 1.0
 */
public class InetSocketAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.baicu.com");
            //根据 IP 地址和端口号创建套接字地址。
            InetSocketAddress socketAddress = new InetSocketAddress(address,80);

            System.out.println(socketAddress.getHostName());
            System.out.println(socketAddress.getPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
