package com.csy.udp;

import java.io.IOException;
import java.net.*;

/**
 * ��Ŀ���ƣ�
 * �����ƣ� Udp�ͻ��ˣ��ͷ���������ͬ�����ࣩ
 * ��������  1) �����ͻ���+�˿�
 *          2) ׼������
 *          3) �����ָ���������˵ĵ�ַ���˿ڣ�
 *          4������
 *          5���ͷ�
 *
 * ����ʱ�䣺2016��03��31�� ����21:17
 *
 * @author csypc
 * @version 1.0
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {

        //�����ͻ���+�˿�
        DatagramSocket client = new DatagramSocket(6666);

        //׼������
        String str = "hello server!";
        byte [] sendData = str.getBytes();
        InetAddress ip = InetAddress.getLocalHost();

        //�����ָ���������˵ĵ�ַ���˿ڣ�
        DatagramPacket packet = new DatagramPacket(sendData,0,sendData.length,ip,8888);
        //����
        client.send(packet);
        //�ͷ�
        client.close();
    }
}
