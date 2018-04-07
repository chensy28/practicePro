package com.csy.http.perfect;


import java.util.HashMap;
import java.util.Map;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������������
 * ����ʱ�䣺2016��04��12�� ����22:24
 *
 * @author csypc
 * @version 1.0
 */
public class ServletContext {
    //Ϊÿ��servlet��һ������
    //private Map<String, Servlet> servlet; //��ֵ���д����ȽϺĿռ䣬�ɴ��·����Ȼ��ͨ������

    private Map<String,String> servlet;

    //������url�����ӳ��
    //  /login --> "login"
    //  /log   --> "login"
    private Map<String,String> mapping;

    public ServletContext() {
        servlet = new HashMap<>();
        mapping = new HashMap<>();
    }

    public Map<String, String> getServlet() {
        return servlet;
    }

    public void setServlet(Map<String, String> servlet) {
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
