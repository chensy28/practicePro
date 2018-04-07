package com.csy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 项目名称：
 * 类名称：
 * 类描述：随机访问文件
 * 创建时间：2016年03月18日 下午08:04
 *
 * @author csypc
 * @version 1.0
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        File file = new File("H:\\iotest\\rand.txt");
        try {
            RandomAccessFile randomAccess = new RandomAccessFile(file,"rw");
            byte []b = {5,6,7,8,9};
            randomAccess.write(b);
            //randomAccess.write(9);
          //  System.out.println(randomAccess.read());//游标已经移到文件尾，返回为-1

            //游标不能为负数
            randomAccess.seek(0);//文件索引下标设置到文件起始处
           // randomAccess.skipBytes(3);
            System.out.println("aa:"+randomAccess.read());

            byte []c = {};
            int num = randomAccess.read(c);
            for(byte t : c){
                System.out.print(t+","+num);
            }
            RandomAccessFile randomAccess2 = new RandomAccessFile(file,"rw");
            //System.out.print(randomAccess2.read());
            while(randomAccess.read() != -1){
                System.out.println(randomAccess2.read());
            }

            randomAccess.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
