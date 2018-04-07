package com.csy.collection;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/16.
 * Time:12:50.
 */
public class EnumerationTest {
    public static void main(String []args){
        //Enumeration 1.5版本之前使用的，新版本可使用Iterator代替
       /* Vector<String> vector = new Vector<>();
        vector.add("aa");
        vector.add("dsd");
        vector.add("bb");
        vector.add("cc");

        //枚举  使用vector获取枚举
        Enumeration<String> en = vector.elements();//返回此向量的组件的枚举。
        while(en.hasMoreElements()){
            System.out.println(en.nextElement());
        }*/

        //使用Enumeration的实现类StringTokenizer
        String str = "123@qq.com;23@soufu.com;@dde.com";
        Enumeration en = new StringTokenizer(str,";");
        while(en.hasMoreElements()){
            System.out.println(en.nextElement());
        }

    }
}
