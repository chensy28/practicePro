package com.csy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ���������ַ����������
 * ����ʱ�䣺2016��03��22�� ����08:49
 *
 * @author csypc
 * @version 1.0
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
       /* try {
            //�������Ŀ�ĵ��ļ����Բ����ڣ������ڻᴴ����
            FileWriter out = new FileWriter("h:\\iotest\\reader.txt");
            char []c = {'a','d','d'};
            out.write(c);
            out.flush();//ǿ�ƽ�����д��Ŀ��

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
            //�������Ŀ�ĵ��ļ����Բ����ڣ������ڻᴴ����
            char []c = {'a','g','g'};
            out.write(c);
            out.flush();//ǿ�ƽ�����д��Ŀ��

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
