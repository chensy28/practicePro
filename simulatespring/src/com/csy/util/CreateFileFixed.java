package com.csy.util;

import com.csy.bo.CommonDate;
import com.csy.bo.Simulation;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by csypc on 2015/10/17.
 */
public class CreateFileFixed {
    public Map<String,Object> createXMLFile(String filename) {

        int returnValue = 0;
        SAXReader reader = new SAXReader();
        Map<String,Object> map = new HashMap<>();
        try {

            File file = new File(filename);
            Document document = reader.read(file);
            Element employees = document.getRootElement();


            for (Iterator i = employees.elementIterator(); i.hasNext();) {

                Element employee = (Element) i.next();
                if(employee.getName().equals("bean")){

                    Attribute attribute1 = employee.attribute("id");
                    String id = attribute1.getValue();

                    Attribute attribute2 = employee.attribute("class");
                    String classPath = attribute2.getValue();

                   // Object object = Class.forName(classPath);



                    if(classPath.equals( "com.csy.bo.Simulation")) {

                        Class cla= Class.forName("com.csy.bo.Simulation");
                        Simulation simulation = (Simulation) cla.newInstance();


                        for (Iterator j = employee.elementIterator(); j.hasNext(); ) {

                            Element child = (Element) j.next();
                            String nameOrPaw = "";
                            if (child.getName().equals("property")) {

                                Attribute refAtrr = child.attribute("ref");
                                if (refAtrr != null && refAtrr.getValue() != "") {

                                    simulation = findRootChildBean(employees, refAtrr.getValue(), simulation);
                                } else {

                                    Attribute attChild = child.attribute("value");
                                    if (attChild != null && attChild.getValue() != "") {
                                        nameOrPaw = attChild.getValue();
                                    } else {
                                        for (Iterator k = child.elementIterator(); k.hasNext(); ) {

                                            Element childAndChild = (Element) k.next();
                                            if (childAndChild.getName().equals("value")) {
                                                String text = childAndChild.getText();
                                                nameOrPaw = text;
                                            }
                                        }
                                    }
                                    Attribute attChild2 = child.attribute("name");
                                    if (attChild2.getValue().equals("username")) {
                                        simulation.setUsername(nameOrPaw);
                                    } else {
                                        simulation.setPassword(nameOrPaw);
                                    }
                                }

                            }


                        }

                        map.put(id, simulation);

                    }else{
                        Class cla= Class.forName("com.csy.bo.CommonDate");
                        CommonDate commonDate = (CommonDate)cla.newInstance();
                        map.put(id,commonDate);
                    }


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

    public Simulation findRootChildBean(Element employees,String beanName,Simulation simulation) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        for (Iterator i = employees.elementIterator(); i.hasNext();) {

            Element employee = (Element) i.next();
            if(employee.getName().equals("bean")){

                Attribute attribute = employee.attribute("id");
                if(attribute != null && attribute.getValue().equals(beanName)){
                    String classPath = employee.attribute("class").getValue();
                    Class c = Class.forName(classPath);
                    CommonDate commonDate = (CommonDate)c.newInstance();
                    simulation.setCommonDate(commonDate);
                }
            }
        }
        return simulation;
    }


}
