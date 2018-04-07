package com.csy.properties;

import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/16.
 * Time:15:53.
 */
public class PropertiesForRead {
    public static void main(String []args) throws IOException {
        Properties pro = new Properties();
        /*pro.setProperty("a","a1a");
        pro.setProperty("b","b2b");
        pro.setProperty("c","c3c")*/;

        //从输入流中去读取属性列表(自己实例化输入流)
        /*InputStream ins = new FileInputStream(new File("collectionTest/test.properties"));
        pro.load(ins);*/

        //根据Class获取输入流（使用Class中的方法获取输入流）
        //pro.load(PropertiesForRead.class.getResourceAsStream("/com/csy/properties/test.properties"));

        //使用Thread线程上下文 ClassLoader获取输入流
        pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/csy/properties/test.properties"));
        System.out.println(pro.getProperty("a"));
    }


}
