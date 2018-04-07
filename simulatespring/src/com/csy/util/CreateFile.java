package com.csy.util;

import com.csy.bo.CommonDate;
import com.csy.bo.Simulation;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by csypc on 2015/10/17.
 */
public class CreateFile {
    public Map<String, Object> createXMLFile(String filename) throws BizException, InvocationTargetException {

        int returnValue = 0;
        SAXReader reader = new SAXReader();
        Map<String, Object> map = new HashMap<>();
        try {

            File file = new File(filename);
            Document document = reader.read(file);
            Element root = document.getRootElement();


            for (Iterator i = root.elementIterator(); i.hasNext(); ) {

                Element element = (Element) i.next();
                if (element.getName().equals("bean")) {

                    Attribute idAttr = element.attribute("id");
                    String id = idAttr.getValue();
                    if (id == null || id.equals("")) {
                        throw new BizException(ErrorCode.MSG_001);
                    }

                    Attribute classAttr = element.attribute("class");
                    String classPath = classAttr.getValue();
                    if (classPath == null || classPath.equals("")) {
                        throw new BizException(ErrorCode.MSG_002);
                    }

                    // Object object = Class.forName(classPath);

                    Class cla = Class.forName(classPath);
                    Object obj = cla.newInstance();
                    Method []methods = cla.getMethods();

                    for (Iterator j = element.elementIterator(); j.hasNext(); ) {

                        Element child = (Element) j.next();
                        Object attValue = null;
                        if (child.getName().equals("property")) {

                            Attribute refAtrr = child.attribute("ref");
                            if (refAtrr != null && refAtrr.getValue() != "") {

                                 findRootChildBean(root, refAtrr.getValue(), obj,methods);
                            } else {

                                Attribute attChild = child.attribute("value");
                                if (attChild != null && attChild.getValue() != "") {
                                    attValue = attChild.getValue();
                                } else {

                                    for (Iterator k = child.elementIterator(); k.hasNext(); ) {

                                        Element childAndChild = (Element) k.next();
                                        if (childAndChild.getName().equals("value")) {
                                            String text = childAndChild.getText();
                                            attValue = text;
                                        }else{
                                            throw new BizException(ErrorCode.MSG_004);
                                        }
                                    }
                                }
                                Attribute nameAttr = child.attribute("name");
                                String name = nameAttr.getValue();
                                if(nameAttr == null && name.equals("")){
                                    throw new BizException(ErrorCode.MSG_003);
                                }

                                invokeMethod(methods ,name,obj,attValue);


                            }

                        }


                    }

                    map.put(id, obj);


                }

            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return map;
    }

    public void findRootChildBean(Element root, String beanName, Object obj,Method [] methods) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        for (Iterator i = root.elementIterator(); i.hasNext(); ) {

            Element element = (Element) i.next();
            if (element.getName().equals("bean")) {

                Attribute attribute = element.attribute("id");
                if (attribute != null && attribute.getValue().equals(beanName)) {
                    String classPath = element.attribute("class").getValue();
                    Class c = Class.forName(classPath);
                    Object newObj = c.newInstance();

                    invokeMethod(methods ,beanName,obj,newObj);

                }
            }
        }
    }

    public void invokeMethod(Method []methods ,String name,Object obj,Object attValue) throws InvocationTargetException, IllegalAccessException {

        for(int index=0;index<methods.length;index++){

            Method method = methods[index];
            String methodName = method.getName();
            String newName = name;
            String subStr1 = newName.substring(0,1);
            subStr1 = "set"+subStr1.toUpperCase();
            String subStr2 = newName.substring(1,newName.length());

            if(methodName.equals(subStr1+subStr2)){

                method.invoke(obj,attValue);
                break;
            }

        }
    }


}
