package com.csy.annocation;

import java.util.Date;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�Demo1
 * ��������ע��
 * ����ʱ�䣺2016��01��26�� ����22:59
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
