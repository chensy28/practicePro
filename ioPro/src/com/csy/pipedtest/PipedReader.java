package com.csy.pipedtest;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 项目名称：
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月23日 下午08:00
 *
 * @author csypc
 * @version 1.0
 */
public class PipedReader extends Thread{
    private PipedInputStream in = new PipedInputStream();

    public PipedInputStream getIn(){
        return in;
    }

    @Override
    public void run() {
         byte []buf = new byte[1024];
        try {
            int len = in.read(buf);
            System.out.println("data from sender:");
            System.out.println(new String(buf,0,len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
