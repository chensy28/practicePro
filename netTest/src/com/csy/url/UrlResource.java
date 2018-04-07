package com.csy.url;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.InternetHeaders;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������ȡ��ҳ��Դ
 * ����ʱ�䣺2016��03��30�� ����22:10
 *
 * @author csypc
 * @version 1.0
 */
public class UrlResource {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");

        //�򿪵��� URL �����Ӳ�����һ�����ڴӸ����Ӷ���� InputStream
        InputStream in = url.openStream();

        byte [] bytes = new byte[1024*1024];

       /* int i=0;
        while(in.read() != -1){    //�����ֽڶ�ȡ
            bytes[i++] = (byte)in.read();
        }*/

      /*  int len = 0;
        while(-1  != (len=in.read(bytes))){ //�����Ϊ��λ���ļ�ĩβ��û�п��õ��ֽڣ��򷵻�ֵ -1
            System.out.println(new String(bytes,0,len));//��ȡ���������ڱ�����벻һ�£�ʹ�����ݳ�������
        }*/

       /* System.out.println(new String(bytes,0,bytes.length));
        System.out.println(bytes.length);*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.htm"),"utf-8"));
        String msg = null;
        while((msg = reader.readLine()) != null){
            //System.out.println(msg);
            writer.write(msg);
        }

        writer.flush();
        writer.close();
        reader.close();

    }
}
