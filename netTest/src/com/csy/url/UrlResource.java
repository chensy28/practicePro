package com.csy.url;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.InternetHeaders;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 项目名称：
 * 类名称：
 * 类描述：获取网页资源
 * 创建时间：2016年03月30日 下午22:10
 *
 * @author csypc
 * @version 1.0
 */
public class UrlResource {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");

        //打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream
        InputStream in = url.openStream();

        byte [] bytes = new byte[1024*1024];

       /* int i=0;
        while(in.read() != -1){    //单个字节读取
            bytes[i++] = (byte)in.read();
        }*/

      /*  int len = 0;
        while(-1  != (len=in.read(bytes))){ //如果因为流位于文件末尾而没有可用的字节，则返回值 -1
            System.out.println(new String(bytes,0,len));//读取的内容由于编码解码不一致，使得内容出现乱码
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
