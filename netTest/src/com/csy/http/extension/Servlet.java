package com.csy.http.extension;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������������Ӧ��װ��Servlet
 * ����ʱ�䣺2016��04��12�� ����21:20
 *
 * @author csypc
 * @version 1.0
 */
public abstract class Servlet {
    public void service(Request request ,Response response) throws Exception{
        doGet(request,response);
        doPost(request,response);
    }

    public abstract void doGet(Request request ,Response response) throws Exception;

    public abstract void doPost(Request request ,Response response) throws Exception;
}
