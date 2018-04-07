package com.csy.http.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

/**
 * 项目名称：
 * 类名称：
 * 类描述：SAX2 事件处理程序
 * 创建时间：2016年04月13日 下午22:02
 *
 * @author csypc
 * @version 1.0
 */
public class PersonHandler extends DefaultHandler{

    //存储解析的对象
    private List<Person> personList;
    private Person person;
    //记录标签名

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

    //文档开始
    @Override
    public void startDocument(){
        System.out.println("接收文档开始的通知");
        personList = new ArrayList<Person>();
    }

    //文档结束
    @Override
    public void endDocument(){
        System.out.println("接收文档结束的通知");
    }


    //元素开始
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

        //System.out.println("接收元素开始的通知"+qName);
    }

    //接收元素中字符数据
    public void characters(char[] ch, int start, int length){

        String context = new String(ch,start,length).trim();
        if(null != tagName && tagName.equals("name")){
            person.setName(context);
        }else if(null != tagName && tagName.equals("age")){
            person.setAge(Integer.parseInt(context));
        }
    }

    //元素结束
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

        //System.out.println("接收元素结束的通知"+qName);
    }
}
