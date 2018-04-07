package com.csy.http.perfect;

import com.csy.http.util.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;
import java.util.List;

/**
 * 项目名称：
 * 类名称：
 * 类描述：SAX2 事件处理程序
 * 创建时间：2016年04月13日 下午22:02
 *
 * @author csypc
 * @version 1.0
 */
public class WebHandler extends DefaultHandler{

    //存储解析的对象
    private List<Entity> entityList;
    private List<Mapping> mappingList;
    private Entity entity;

    private Mapping mapping;
    //记录标签名
    private String beforeTag;
    private boolean isMap = false;//是否是servlet-mapping标签

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

    //文档开始
    @Override
    public void startDocument(){
        System.out.println("接收文档开始的通知");
        entityList = new ArrayList<Entity>();
        mappingList = new ArrayList<Mapping>();
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

    //接收元素中字符数据
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

    //元素结束
    @Override
    public void endElement (String uri, String localName, String qName) throws SAXException
    {
        if(qName.equals("servlet")){
            entityList.add(entity);
        }else if(qName.equals("servlet-mapping")){
            mappingList.add(mapping);
        }

        //TODO 标签标识判断url 没有解析到
        beforeTag = null;
        isMap = false;

        //System.out.println("接收元素结束的通知"+qName);
    }
}
