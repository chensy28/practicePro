package com.csy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������������ļ�
 * ����ʱ�䣺2016��03��18�� ����08:04
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
          //  System.out.println(randomAccess.read());//�α��Ѿ��Ƶ��ļ�β������Ϊ-1

            //�α겻��Ϊ����
            randomAccess.seek(0);//�ļ������±����õ��ļ���ʼ��
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
