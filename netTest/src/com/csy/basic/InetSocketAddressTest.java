package com.csy.basic;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ������������ʵ�� IP �׽��ֵ�ַ��IP ��ַ + �˿ںţ�
 * ����ʱ�䣺2016��03��29�� ����08:53
 *
 * @author csypc
 * @version 1.0
 */
public class InetSocketAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.baicu.com");
            //���� IP ��ַ�Ͷ˿ںŴ����׽��ֵ�ַ��
            InetSocketAddress socketAddress = new InetSocketAddress(address,80);

            System.out.println(socketAddress.getHostName());
            System.out.println(socketAddress.getPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
