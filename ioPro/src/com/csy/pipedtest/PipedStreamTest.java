package com.csy.pipedtest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 项目名称：
 * 类名称：
 * 类描述：管道输入流应该连接到管道输出流；管道输入流提供要写入管道输出流的所有数据字节。
 *          不建议对这两个对象尝试使用单个线程，因为这样可能死锁线程。
 * 创建时间：2016年03月23日 下午08:18
 *
 * @author csypc
 * @version 1.0
 */
public class PipedStreamTest {
    public static void main(String[] args) {
        //在Java中，可以使用管道流进行线程之间的通信
        PipedReader reader = new PipedReader();
        PipedSender sender = new PipedSender();

        PipedOutputStream out = new PipedSender().getOut();
        PipedInputStream in = new PipedReader().getIn();

        //将管道进行连接
        try {
            in.connect(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //启动线程，对数据进行读取或写入
        reader.start();
        sender.start();                       //此程序抛出java.io.IOException: Pipe not connected
    }
}
