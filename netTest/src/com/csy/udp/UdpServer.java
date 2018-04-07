package com.csy.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������UDP ��������
 *         1������������+�˿�
 *         2)׼�����յ�����
 *         3����װ�ɰ�
 *         4)��������
 *         5����������
 *         6���ͷ���Դ
 *
 * ����ʱ�䣺2016��03��31�� ����21:00
 *
 * @author csypc
 * @version 1.0
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {

        //����������+�˿�
        DatagramSocket server = new DatagramSocket(8888);
        //׼�����յ�����
        byte [] buf = new byte[1024];
        //��װ�ɰ�
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        //��������
        server.receive(packet);
        //��������
        byte [] datas = packet.getData();
        int len = datas.length;
        System.out.println(new String(datas,0,len));
        //�ͷ���Դ
        server.close();
    }
}
