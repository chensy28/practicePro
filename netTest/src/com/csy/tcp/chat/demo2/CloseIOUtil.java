package com.csy.tcp.chat.demo2;

import java.io.Closeable;
import java.io.IOException;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ���������ر�������
 * ����ʱ�䣺2016��04��04�� ����22:21
 *
 * @author csypc
 * @version 1.0
 */
public class CloseIOUtil {
    public static void closeAll(Closeable... ios){
        for(Closeable temp : ios){
            if(temp != null){
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
