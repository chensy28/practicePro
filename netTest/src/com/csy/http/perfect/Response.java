package com.csy.http.perfect;

import java.io.*;
import java.util.Date;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������װ��Ӧ��Ϣ
 * ����ʱ�䣺2016��04��08�� ����09:54
 *
 * @author csypc
 * @version 1.0
 */
public class Response {
    //�н�������س���
    public static String CRLF = "\r\n";
    public static String BLANK = " ";//����

    //��Ӧͷ����Ϣ
    private StringBuilder headInfo;

    //��Ӧ�����ֽ���
    private int len;

    private OutputStream outputStream;

    private StringBuilder context;

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Response(){
        headInfo = new StringBuilder();
        context = new StringBuilder();
        len = 0;
    }

    public Response(OutputStream outputStream){
        this();
        this.outputStream = outputStream;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    //������Ӧͷ��Ϣ
    public void createHead(int code){
        //HttpЭ��汾��״̬���롢����
        headInfo.append("HTTP/1.1").append(BLANK);
        //״̬�����ж�
        switch (code){
            case 200 :
                headInfo.append(code).append("BLANK").append("ok").append(CRLF);;
                break;
            case 404 :
                headInfo.append(code).append("BLANK").append("Not found!").append(CRLF);;
                break;
            case 500 :
                headInfo.append(code).append("BLANK").append("Server error!").append(CRLF);;
                break;
        }
        //��Ӧͷ
        headInfo.append("Server:csy").append(BLANK).append("Server/0.0.1").append(CRLF);
        headInfo.append("Date:").append(new Date()).append(CRLF);
        //��Ӧ�ĸ�ʽ
        headInfo.append("Context-type:text/html;charset-GBK").append(CRLF);
        //��Ӧ���ֽ���
        headInfo.append("Context-Length:").append(len).append(CRLF);

        //��Ӧ����ǰ
        headInfo.append(CRLF);
    }


    //������Ϣ���ͻ���
    public void pushToClient(){
        //д������
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        try {
            writer.write(context.toString());
            writer.flush();
            close(writer,outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //��������
    public void print(String info){
        this.context = headInfo.append(info);
    }

    //�ر���
    public void close(Closeable... io){
        for(Closeable temp : io){
            if(temp != null){
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
