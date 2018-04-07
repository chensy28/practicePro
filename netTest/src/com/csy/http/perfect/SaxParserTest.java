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
 * 项目名称：
 * 类名称：
 * 类描述：SAXParser基于事件的解析器，逐行解析
 * 创建时间：2016年04月13日 下午21:53
 *
 * @author csypc
 * @version 1.0
 */
public class SaxParserTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //获取解析器工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //从解析器工厂中获取解析器
        SAXParser saxParser = factory.newSAXParser();
        //加载文档注册处理器
        //编写处理器
        WebHandler webHandler = new WebHandler();
        //加载xml资源
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/csy/http/perfect/web.xml");
        //InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/csy/http/util/bean.xml");
        saxParser.parse(inputStream,webHandler);

        List<Entity> entityList = webHandler.getEntityList();
        List<Mapping> mappingList = webHandler.getMappingList();

        for(Entity entity : entityList){
            System.out.println("解析数据entity："+entity.getName()+"--->"+entity.getClz());
        }

        for(Mapping mapping : mappingList){
            System.out.println("解析数据mapping："+mapping.getName()+"--->"+mapping.getUrlList());
        }
    }
}
