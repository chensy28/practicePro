package com.csy.http.perfect;

import com.csy.http.util.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;
import java.util.List;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������SAX2 �¼��������
 * ����ʱ�䣺2016��04��13�� ����22:02
 *
 * @author csypc
 * @version 1.0
 */
public class WebHandler extends DefaultHandler{

    //�洢�����Ķ���
    private List<Entity> entityList;
    private List<Mapping> mappingList;
    private Entity entity;

    private Mapping mapping;
    //��¼��ǩ��
    private String beforeTag;
    private boolean isMap = false;//�Ƿ���servlet-mapping��ǩ

    public List<Entity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<Entity> entityList) {
        this.entityList = entityList;
    }

    public List<Mapping> getMappingList() {
        return mappingList;
    }

    public void setMappingList(List<Mapping> mappingList) {
        this.mappingList = mappingList;
    }

    //�ĵ���ʼ
    @Override
    public void startDocument(){
        System.out.println("�����ĵ���ʼ��֪ͨ");
        entityList = new ArrayList<Entity>();
        mappingList = new ArrayList<Mapping>();
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

        if(qName.equals("servlet")){
             entity = new Entity();
             isMap = false;
        }else if(qName.equals("servlet-mapping")){
            mapping = new Mapping();
            isMap = true;
        }

        if(!isMap) {
            if(qName.equals("servlet-name")){
                beforeTag = "servlet-name";
            }else if(qName.equals("servlet-class")){
                beforeTag = "servlet-class";
            }
        }else{
            if(qName.equals("servlet-name")){
                beforeTag = "servlet-name";
            }else if(qName.equals("url-pattern")){
                beforeTag = "url-pattern";
            }
        }


    }

    //����Ԫ�����ַ�����
    public void characters(char[] ch, int start, int length){

        String context = new String(ch,start,length).trim();
        if(!isMap){
            if(null != beforeTag && beforeTag.equals("servlet-name")){
                entity.setName(context);
            }else if(null != beforeTag && beforeTag.equals("servlet-class")){
                entity.setClz(context);
            }
        }else{
            if(null != beforeTag && beforeTag.equals("servlet-name")){
                mapping.setName(context);
            }else if(null != beforeTag && beforeTag.equals("url-pattern")){
                mapping.getUrlList().add(context);
            }
        }


    }

    //Ԫ�ؽ���
    @Override
    public void endElement (String uri, String localName, String qName) throws SAXException
    {
        if(qName.equals("servlet")){
            entityList.add(entity);
        }else if(qName.equals("servlet-mapping")){
            mappingList.add(mapping);
        }

        //TODO ��ǩ��ʶ�ж�url û�н�����
        beforeTag = null;
        isMap = false;

        //System.out.println("����Ԫ�ؽ�����֪ͨ"+qName);
    }
}
