package com.csy.test;

import com.csy.bo.OneBo;
import com.csy.bo.Simulation;
import com.csy.iservice.CsyApplicationContext;
import com.csy.service.impl.CsyClassPathXmlApplicationContext;
import com.csy.util.BizException;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by csypc on 2015/10/17.
 */
public class CsyTest {

    public static void main(String []args) throws InvocationTargetException, BizException {

        CsyApplicationContext csyApplicationContext = new CsyClassPathXmlApplicationContext("E:\\ideaworkspace\\simulatespring\\csyApplicationContext.xml");
       /* Simulation simulation = (Simulation)csyApplicationContext.getBean("simulation");
        System.out.print(simulation.getUsername()+","+simulation.getPassword()+","+simulation.getCommonDate().showDate()+"\n");*/

        OneBo oneBo =(OneBo)csyApplicationContext.getBean("oneBo");
        System.out.print(oneBo.getPrice()+","+oneBo.getSex());


    }
}
