package com.csy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 项目名称：
 * 类名称：
 * 类描述：字符输入输出类
 * 创建时间：2016年03月22日 下午08:49
 *
 * @author csypc
 * @version 1.0
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
       /* try {
            //输出流中目的地文件可以不存在，不存在会创建的
            FileWriter out = new FileWriter("h:\\iotest\\reader.txt");
            char []c = {'a','d','d'};
            out.write(c);
            out.flush();//强制将数据写到目标

            char []d = new char[1024];
            FileReader in = new FileReader("h:\\iotest\\reader.txt");
            int size = in.read(d);
            for(int i=0;i<size;i++){
                System.out.print(d[i]+"\t");
            }

            out.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //try-with-resource
        try (FileWriter out = new FileWriter("h:\\iotest\\reader.txt");
             FileReader in = new FileReader("h:\\iotest\\reader.txt");
        ){
            //输出流中目的地文件可以不存在，不存在会创建的
            char []c = {'a','g','g'};
            out.write(c);
            out.flush();//强制将数据写到目标

            char []d = new char[1024];
            int size = in.read(d);
            for(int i=0;i<size;i++){
                System.out.print(d[i]+"\t");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
