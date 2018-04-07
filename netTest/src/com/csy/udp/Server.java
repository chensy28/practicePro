package com.csy.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������UDP ��������  ������ת����
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
public class Server {
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

        double d = convertToBasic(datas);
        System.out.println(d);

        server.close();
    }

    public static double convertToBasic(byte []arr) throws IOException {
        double var = 0.0;
        ByteArrayInputStream bis = new ByteArrayInputStream(arr);
        //�ӿ����ڴӶ��������ж�ȡ�ֽڣ����������� Java �����������ݽ����ع���
        DataInputStream dis = new DataInputStream(bis);
        var = dis.readDouble();
        dis.close();
        return var;
    }
}
