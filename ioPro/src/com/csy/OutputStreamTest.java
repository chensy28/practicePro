package com.csy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��03��19�� ����21:29
 *
 * @author csypc
 * @version 1.0
 */
public class OutputStreamTest {
    public static void main(String[] args) {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {//��ָ�����ֽ�д����������

            }
        };

        try {
            out.flush();//ˢ�´��������ǿ��д�����л��������ֽڡ�
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
