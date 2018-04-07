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
        //设置值、取值
        pro.setProperty("a","a1a5555");
        pro.setProperty("b","b2ssssssssb");
        pro.setProperty("c","csdds3c");

        //将键、值写入属性文件
        //绝对路径（带有盘符的）
        /*OutputStream out = new FileOutputStream(new File("e:/test.properties"));
        pro.store(out,"properties属性文件");   //写入到properties属性文件

        OutputStream out2 = new FileOutputStream(new File("e:/test.xml"));
        pro.storeToXML(out2,"xml属性文件");     //写入到xml属性文件*/

        //相对路径（不带盘符的，相对工程路径的）
        OutputStream out = new FileOutputStream(new File("collectionTest/test.properties"));
        pro.store(out,"properties属性文件");   //写入到properties属性文件

    }


}
