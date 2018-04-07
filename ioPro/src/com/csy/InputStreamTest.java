package com.csy;

import java.io.IOException;
import java.io.InputStream;

/**
 * 项目名称：
 * 类名称：
 * 类描述：所有字节输入流的抽象类
 * 创建时间：2016年03月19日 下午21:08
 *
 * @author csypc
 * @version 1.0
 */
public class InputStreamTest {
    public static void main(String[] args) {
        InputStream input = new InputStream() {
            //返回 0 到 255 范围内的 int 字节值。
            @Override
            public int read() throws IOException {//下一个数据字节；如果到达流的末尾，则返回 -1。
                return 2;
            }

        };
        try {
            System.out.println(input.available());
            System.out.println(input.markSupported());

            //关闭此输入流并释放与该流关联的所有系统资源(会将内存缓存区数据刷新到外部设备)
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
