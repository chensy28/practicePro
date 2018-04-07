package com.csy.tcp.chat.demo3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


/**
 * ��Ŀ���ƣ�
 * ������:�����ҽ�����ʾ
 * ����ʱ�䣺2016��04��03�� ����17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Server {
    //�����������еĿͻ���
    private List<MyChannel> all = new ArrayList<MyChannel>();

    public static void main(String[] args) throws IOException {
       new Server().start();
    }

    public void start() throws IOException {
        //�����������ˣ��ƶ��˿�
        ServerSocket serverSocket = new ServerSocket(8889);
        //ѭ����ȡ
        while(true) {
            //���տͻ������ӡ�����ʽ�ģ���ȡ��ͨ��ͨ����
            Socket socket = serverSocket.accept();
            MyChannel myChannel = new MyChannel(socket);
            new Thread(myChannel).start();
            all.add(myChannel);//����ͻ���
        }
    }

    /**
     *
     * һ���ͻ��ˣ�һ����·
     * 1.������
     * 2.�����
     * 3.��������
     * 4.��������
     */
    private class MyChannel implements Runnable{

        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning = true;

        public MyChannel(Socket socket){

            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());

            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                CloseIOUtil.closeAll(dis,dos);
            }

        }

        //��������
        public String receive(){
            String msg = "";
            try {
                 msg = dis.readUTF();
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                CloseIOUtil.closeAll(dis);
                all.remove(this);//�����쳣���Ƴ�����
            }
            return msg;
        }

        //��������
        public void send(String msg){
            //������Ϊ�գ��򲻷���
            if(msg == null || msg.equals("")){
                return ;
            }

            try {
                dos.writeUTF(msg);
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                CloseIOUtil.closeAll(dos);
                all.remove(this);//�����쳣���Ƴ�����
            }
        }

        //���͸������ͻ���
        public void sendOther(){
            String msg = receive();
            for(MyChannel other : all){
                if(other == this){
                    continue;
                }
                other.send(msg);
            }
        }

        @Override
        public void run() {
            while(isRunning){
                sendOther();//ת���������ͻ���
            }
        }
    }
 }
