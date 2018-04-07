package com.csy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 项目名称：
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月19日 下午21:29
 *
 * @author csypc
 * @version 1.0
 */
public class OutputStreamTest {
    public static void main(String[] args) {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {//将指定的字节写入此输出流。

            }
        };

        try {
            out.flush();//刷新此输出流并强制写出所有缓冲的输出字节。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
