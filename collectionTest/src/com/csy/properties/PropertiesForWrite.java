package com.csy.properties;

import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/16.
 * Time:15:53.
 */
public class PropertiesForWrite {
    public static void main(String []args) throws IOException {
        Properties pro = new Properties();
        //����ֵ��ȡֵ
        pro.setProperty("a","a1a5555");
        pro.setProperty("b","b2ssssssssb");
        pro.setProperty("c","csdds3c");

        //������ֵд�������ļ�
        //����·���������̷��ģ�
        /*OutputStream out = new FileOutputStream(new File("e:/test.properties"));
        pro.store(out,"properties�����ļ�");   //д�뵽properties�����ļ�

        OutputStream out2 = new FileOutputStream(new File("e:/test.xml"));
        pro.storeToXML(out2,"xml�����ļ�");     //д�뵽xml�����ļ�*/

        //���·���������̷��ģ���Թ���·���ģ�
        OutputStream out = new FileOutputStream(new File("collectionTest/test.properties"));
        pro.store(out,"properties�����ļ�");   //д�뵽properties�����ļ�

    }


}
