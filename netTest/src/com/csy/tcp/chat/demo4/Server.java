package com.csy.tcp.chat.demo4;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������������(�����̣߳�ʹ�÷���˿��Դ������ͻ�������,��ȡ�����û���Ⱥ�˳��)
 * ����ʱ�䣺2016��04��03�� ����17:13
 *
 * @author csypc
 * @version 1.0
 */
public class Server {
    //�����������еĿͻ���
    private List<MyChannel> all = new ArrayList<MyChannel>();


    public static void main(String[] args) throws IOException {
       new Server().startRun();
    }

    public void startRun() throws IOException {
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

        private BufferedReader br;
        private BufferedWriter bw;
        private boolean isRunning = true;
        private String name;

        public MyChannel(Socket socket){

            try {
                //���롢�����Ҫ��Ӧʹ��
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                this.name = br.readLine();
                System.out.println(name);

                send("��ӭ�����������");
                sendOther(name+"������������");

            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                com.csy.tcp.chat.demo4.CloseIOUtil.closeAll(br, bw);
            }

        }

        //��������
        public String receive(){
            String msg = "";
            try {
                 msg = br.readLine();
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                com.csy.tcp.chat.demo3.CloseIOUtil.closeAll(br);
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
                bw.write(msg);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                CloseIOUtil.closeAll(bw);
                all.remove(this);//�����쳣���Ƴ�����
            }
        }

        //���͸������ͻ���
        public void sendOther(String msg){
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
                sendOther(receive());//ת���������ͻ���
            }
        }
    }
 }
