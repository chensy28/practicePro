package com.test;

import com.service.BasicTest;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by csypc on 2015/10/17.
 */
public class Test {
    public static void main(String[] args) {

       /* BasicTest b = new BasicTest();
        b.setName("sdfdfds");
        System.out.print(b.getName());*/
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        BasicTest test = (BasicTest) application.getBean("basicTest");
        System.out.print(test.getName());
    }
}
