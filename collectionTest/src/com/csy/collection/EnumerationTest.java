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
        //Enumeration 1.5�汾֮ǰʹ�õģ��°汾��ʹ��Iterator����
       /* Vector<String> vector = new Vector<>();
        vector.add("aa");
        vector.add("dsd");
        vector.add("bb");
        vector.add("cc");

        //ö��  ʹ��vector��ȡö��
        Enumeration<String> en = vector.elements();//���ش������������ö�١�
        while(en.hasMoreElements()){
            System.out.println(en.nextElement());
        }*/

        //ʹ��Enumeration��ʵ����StringTokenizer
        String str = "123@qq.com;23@soufu.com;@dde.com";
        Enumeration en = new StringTokenizer(str,";");
        while(en.hasMoreElements()){
            System.out.println(en.nextElement());
        }

    }
}
