package com.csy.annocation;

import java.util.Date;

/**
 * 项目名称：springbasic
 * 类名称：Demo1
 * 类描述：注解
 * 创建时间：2016年01月26日 下午22:59
 *
 * @author csypc
 * @version 1.0
 */
public class Demo1 extends Object {
    @Override
    public String toString(){
        return "";
    }

    @Deprecated
    public void dateDeal(){
        Date date = new Date();
        date.getYear();
    }
//    @interface

}
