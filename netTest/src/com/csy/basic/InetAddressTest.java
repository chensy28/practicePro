package com.csy.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������ʾ������Э�� (IP) ��ַ
 * ����ʱ�䣺2016��03��29�� ����08:35
 *
 * @author csypc
 * @version 1.0
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            // ���ر���������
            //InetAddress address = InetAddress.getLocalHost();

            //�ڸ����������������ȷ�������� IP ��ַ��
            //InetAddress address = InetAddress.getByName("www.baidu.com");

            byte[] addr = {127,0,0,1};
            //�ڸ���ԭʼ IP ��ַ������£����� InetAddress ����
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
