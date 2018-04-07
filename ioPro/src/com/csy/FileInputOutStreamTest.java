package com.csy;

import java.io.*;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ���������ļ����������
 * ����ʱ�䣺2016��03��22�� ����08:13
 *
 * @author csypc
 * @version 1.0
 */
public class FileInputOutStreamTest {
    public static void main(String[] args) {
        File file = new File("h:\\iotest\\file.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                //e.printStackTrace();��ӡ���켣
                throw new RuntimeException(e);
            }
        }
        try {
            //������д�������
            FileOutputStream outputStream = new FileOutputStream(file);
            byte []b = {1,3,4,5,'a','b'};
            outputStream.write(b);

            //����������������
            FileInputStream inputStream = new FileInputStream(file);
            byte []c = new byte[1024];
            int size = inputStream.read(c);
            for(int i=0;i<size;i++){
                System.out.print(c[i]+"\t");
            }

            //�ǵ��������Ժ�Ҫ�ر�������Ȼ��ľ���Դ
            inputStream.close();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
