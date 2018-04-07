package com.csy.http.util;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������SAXParser�����¼��Ľ����������н���
 * ����ʱ�䣺2016��04��13�� ����21:53
 *
 * @author csypc
 * @version 1.0
 */
public class SaxParserTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //��ȡ����������
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //�ӽ����������л�ȡ������
        SAXParser saxParser = factory.newSAXParser();
        //�����ĵ�ע�ᴦ����
        //��д������
        PersonHandler personHandler = new PersonHandler();
        //����xml��Դ
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/csy/http/util/person.xml");
        //InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/csy/http/util/bean.xml");
        saxParser.parse(inputStream,personHandler);

        List<Person> personList = personHandler.getPersonList();
        for(Person person : personList){
            System.out.println("�������ݣ�"+person.getName()+"--->"+person.getAge());
        }
    }
}
