package com.csy.http.perfect;

import com.csy.http.util.Person;
import com.csy.http.util.PersonHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
        WebHandler webHandler = new WebHandler();
        //����xml��Դ
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/csy/http/perfect/web.xml");
        //InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/csy/http/util/bean.xml");
        saxParser.parse(inputStream,webHandler);

        List<Entity> entityList = webHandler.getEntityList();
        List<Mapping> mappingList = webHandler.getMappingList();

        for(Entity entity : entityList){
            System.out.println("��������entity��"+entity.getName()+"--->"+entity.getClz());
        }

        for(Mapping mapping : mappingList){
            System.out.println("��������mapping��"+mapping.getName()+"--->"+mapping.getUrlList());
        }
    }
}
