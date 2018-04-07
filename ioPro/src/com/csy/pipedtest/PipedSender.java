package com.csy.pipedtest;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * 项目名称：
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月22日 下午23:00
 * @author csypc
 * @version 1.0
 */
public class PipedSender extends Thread{
    private PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOut(){
        return out;
    }

    @Override
    public void run() {
        String str = new String("csfdddssdds");
        try {
            out.write(str.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
