package com.csy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��18�� ����08:25
 *
 * @author csypc
 * @version 1.0
 */
public class RandomTest {
    public static void main(String[] args) {
        File file = new File("H:\\iotest\\rand.txt");
        try {
            RandomAccessFile access = new RandomAccessFile(file,"rw");
           // access.seek(0);
            //int a = access.read();
            byte[] b = {};
            System.out.println(access.read(b));
            for(byte t : b){
                System.out.print(t+",");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
