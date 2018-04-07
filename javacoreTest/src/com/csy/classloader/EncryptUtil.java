package com.csy.classloader;

import java.io.*;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��05�� ����07:59
 *
 * @author csypc
 * @version 1.0
 */
public class EncryptUtil {

    public static void main(String[] args) {
        encrypt("H:/myjavatest/com/csy/HelloWorld.class","H:/myjavatest/com/csy/temp/HelloWorld.class");
    }

    public static void encrypt(String src,String desc){
        try {
            InputStream is = new FileInputStream(new File(src));
            OutputStream os = new FileOutputStream(new File(desc));

            int temp = -1;
            //�����ֽڶ�ȡ������0��255֮���int���ֽ�ֵ����û�п��õ��ֽڣ��򷵻�-1
            try {
                while((temp = is.read()) != -1){
                    //���ܣ���ԭ��������ȡ����
                    os.write(temp ^ 0xff);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                //�ر���
                if(is != null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(os != null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
