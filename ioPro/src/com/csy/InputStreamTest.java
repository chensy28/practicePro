package com.csy;

import java.io.IOException;
import java.io.InputStream;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * �������������ֽ��������ĳ�����
 * ����ʱ�䣺2016��03��19�� ����21:08
 *
 * @author csypc
 * @version 1.0
 */
public class InputStreamTest {
    public static void main(String[] args) {
        InputStream input = new InputStream() {
            //���� 0 �� 255 ��Χ�ڵ� int �ֽ�ֵ��
            @Override
            public int read() throws IOException {//��һ�������ֽڣ������������ĩβ���򷵻� -1��
                return 2;
            }

        };
        try {
            System.out.println(input.available());
            System.out.println(input.markSupported());

            //�رմ����������ͷ����������������ϵͳ��Դ(�Ὣ�ڴ滺��������ˢ�µ��ⲿ�豸)
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
