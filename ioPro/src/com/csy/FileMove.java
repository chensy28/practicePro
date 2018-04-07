package com.csy;

import java.io.File;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ���������������ļ�����������ָ��Ŀ¼
 * ����ʱ�䣺2016��03��17�� ����07:38
 *
 * @author csypc
 * @version 1.0
 */
public class FileMove {
    public static void main(String[] args) {
        File dst = new File("H:\\iotest\\dst");
        if(!dst.exists()){
            dst.mkdir();
        }

        File src = new File("H:\\iotest");
        move(src,dst);
    }

    public static void move(File file,File dst){
        /*System.out.println("path:"+dst.getPath());
        System.out.println(dst.getAbsolutePath());*/
        File[] files = file.listFiles();
        for (File f : files){
            if(f.isDirectory()){
               move(f,dst);
            }else{
                //���������ƶ���ָ����Ŀ¼
                //f.renameTo(new File(dst.getPath()+f.getName().substring(0, f.getName().indexOf("."))+".jab"));
                //f.renameTo(new File("H:\\"+f.getName().substring(0, f.getName().indexOf("."))+".jab"));
                f.renameTo(new File("H:\\aj.txt"));
            }
        }
    }
}
