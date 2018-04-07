package com.csy.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 项目名称：
 * 类名称：
 * 类描述：表示互联网协议 (IP) 地址
 * 创建时间：2016年03月29日 下午08:35
 *
 * @author csypc
 * @version 1.0
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            // 返回本地主机。
            //InetAddress address = InetAddress.getLocalHost();

            //在给定主机名的情况下确定主机的 IP 地址。
            //InetAddress address = InetAddress.getByName("www.baidu.com");

            byte[] addr = {127,0,0,1};
            //在给定原始 IP 地址的情况下，返回 InetAddress 对象。
            InetAddress address = InetAddress.getByAddress(addr);

            byte []bytes = address.getAddress();
            //System.out.println(bytes);
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
