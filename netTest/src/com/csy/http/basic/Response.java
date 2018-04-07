package com.csy.http.basic;

import java.io.*;
import java.util.Date;

/**
 * 项目名称：
 * 类名称：
 * 类描述：封装响应信息
 * 创建时间：2016年04月08日 下午09:54
 *
 * @author csypc
 * @version 1.0
 */
public class Response {
    //行结束符与回车符
    public static String CRLF = "\r\n";
    public static String BLANK = " ";//空行

    //响应头部信息
    private StringBuilder headInfo;

    //响应正文字节数
    private int len;

    private OutputStream outputStream;

    private StringBuilder context;

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

    //创建响应头信息
    public void createHead(int code){
        //Http协议版本、状态代码、描述
        headInfo.append("HTTP/1.1").append(BLANK);
        //状态代码判断
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
        //响应头
        headInfo.append("Server:csy").append(BLANK).append("Server/0.0.1").append(CRLF);
        headInfo.append("Date:").append(new Date()).append(CRLF);
        //响应的格式
        headInfo.append("Context-type:text/html;charset-GBK").append(CRLF);
        //响应的字节数
        headInfo.append("Context-Length:").append(len).append(CRLF);

        //响应正文前
        headInfo.append(CRLF);
    }


    //发送信息到客户端
    public void pushToClient(){

        //写到流中
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        try {
            writer.write(context.toString());
            writer.flush();
            close(writer,outputStream);
            System.out.println("封装response响应\n"+context.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //构建正文
    public void print(String info){
        this.context = headInfo.append(info);
    }

    //关闭流
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
