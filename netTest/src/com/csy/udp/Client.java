package com.csy.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ��Ŀ���ƣ�
 * �����ƣ� Udp�ͻ���(����ת����ʹ����)
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
public class Client {
    public static void main(String[] args) throws IOException {

        //�����ͻ���+�˿�
        DatagramSocket client = new DatagramSocket(6666);

        //׼������
        byte [] sendData =  convertToBytes(82.15);
        InetAddress ip = InetAddress.getLocalHost();

        //�����ָ���������˵ĵ�ַ���˿ڣ�
        DatagramPacket packet = new DatagramPacket(sendData,0,sendData.length,ip,8888);
        //����
        client.send(packet);
        //�ͷ�
        client.close();

    }

    public static byte[] convertToBytes(double num) throws IOException {
        byte[] bytes = null;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeDouble(num);

        bytes = bos.toByteArray();
        dos.flush();
        dos.close();
        return bytes;
    }




}
