package com.csy.properties;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/16.
 * Time:15:53.
 */
public class PropertiesTest {
    public Node getNode(String name){
        return new Node(name);
    }
    public static void main(String []args) {
        Properties pro = new Properties();
        //����ֵ��ȡֵ
        /*pro.setProperty("a","a1a");
        pro.setProperty("b","b2b");
        pro.setProperty("c","c3c");

        Set set = pro.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(pro.getProperty(obj.toString()));
        }*/

        /*pro.put(new Integer(1),2);
        System.out.print(pro.get(new Integer(1)));*/

        //�����б���ÿ���������Ӧֵ����һ���ַ���������ʹ��setProperty,getProperty��ֵ��ȡֵ
       /* PropertiesTest test = new PropertiesTest();
        Node node = test.getNode("bb");
        Node node2 = test.getNode("fff");
        pro.put(node,node2);
        System.out.print(pro.get(node));*/
    }

    class Node{
        private String name;
        public Node(){}
        public Node(String name) {
            this.name = name;
        }
    }
}
