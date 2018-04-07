package com.csy.service.impl;

import com.csy.iservice.CsyApplicationContext;
import com.csy.util.BizException;
import com.csy.util.CreateFile;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by csypc on 2015/10/17.
 */
public class CsyClassPathXmlApplicationContext implements CsyApplicationContext {

    private Object bean;
    private Map<String,Object> map;

    @Override
    public Object getBean(String beanName) {

        return map.get(beanName);
    }

    public CsyClassPathXmlApplicationContext(String configLocation) throws InvocationTargetException, BizException {

        CreateFile createFile = new CreateFile();
        Map<String,Object> map = createFile.createXMLFile(configLocation);
        this.map = map;
    }
}
