package com.csy.http.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������SAX2 �¼��������
 * ����ʱ�䣺2016��04��13�� ����22:02
 *
 * @author csypc
 * @version 1.0
 */
public class PersonHandler extends DefaultHandler{

    //�洢�����Ķ���
    private List<Person> personList;
    private Person person;
    //��¼��ǩ��

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    private String tagName;

    //�ĵ���ʼ
    @Override
    public void startDocument(){
        System.out.println("�����ĵ���ʼ��֪ͨ");
        personList = new ArrayList<Person>();
    }

    //�ĵ�����
    @Override
    public void endDocument(){
        System.out.println("�����ĵ�������֪ͨ");
    }


    //Ԫ�ؿ�ʼ
    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException
    {

        if(qName.equals("person")){
            person = new Person();
        }else if(qName.equals("name")){
            tagName = "name";
        }else if(qName.equals("age")){
            tagName = "age";
        }

        //System.out.println("����Ԫ�ؿ�ʼ��֪ͨ"+qName);
    }

    //����Ԫ�����ַ�����
    public void characters(char[] ch, int start, int length){

        String context = new String(ch,start,length).trim();
        if(null != tagName && tagName.equals("name")){
            person.setName(context);
        }else if(null != tagName && tagName.equals("age")){
            person.setAge(Integer.parseInt(context));
        }
    }

    //Ԫ�ؽ���
    @Override
    public void endElement (String uri, String localName, String qName) throws SAXException
    {
        if(qName.equals("person")){
            personList.add(person);
            tagName = null;
        }else if(qName.equals("name")){
            tagName = null;
        }else if(qName.equals("age")){
            tagName = null;
        }

        //System.out.println("����Ԫ�ؽ�����֪ͨ"+qName);
    }
}
