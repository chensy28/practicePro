package com.csy.http.basic;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������������Ӧ��װ��Servlet
 * ����ʱ�䣺2016��04��12�� ����21:20
 *
 * @author csypc
 * @version 1.0
 */
public class Servlet {
    public void service(Request request ,Response response){

        response.createHead(200);
        String context = "<html><head><title>response��Ӧss��װ</title></head><body>12ssss</body></html>";
        response.print(context);
    }
}
