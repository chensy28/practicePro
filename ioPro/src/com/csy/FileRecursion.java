package com.csy;

import java.io.File;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * �����������õݹ��г�ȫ���ļ�
 * ����ʱ�䣺2016��03��17�� ����07:26
 *
 * @author csypc
 * @version 1.0
 */
public class FileRecursion {
    public static void main(String[] args) {
        File file = new File("H:\\iotest");
        show(file);
    }

    public static void show(File file){
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){  //����Ŀ¼�������ݹ�
                show(f);
            }else{  //�ҵ��ļ���������Ӧ����
                System.out.println(f.getName());
            }
        }
    }
}
