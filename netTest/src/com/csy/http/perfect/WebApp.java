package com.csy.http.perfect;

import java.util.Map;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ������������������
 * ����ʱ�䣺2016��04��12�� ����23:04
 *
 * @author csypc
 * @version 1.0
 */
public class WebApp {
    private static ServletContext servletContext;
    static {
        /*private Map<String, Servlet> servlet;

        //������url�����ӳ��
        //  /login --> "login"
        //  /log   --> "login"
        private Map<String,String> mapping;*/

        //TODO ����xml�е������滻
        servletContext = new ServletContext();
        Map<String,String> mapping = servletContext.getMapping();
        mapping.put("/login", "login");
        mapping.put("/log", "login");
        mapping.put("/regist", "regist");

        //����Ҫ�޸�ӳ�䣬��Ҫ�Գ�����б���ִ�У��ɽ�ӳ����Ϣ���������ļ�
        Map<String,String> servletMap = servletContext.getServlet();
        servletMap.put("login","com.csy.http.extension.LoginServlet");
        servletMap.put("regist","com.csy.http.extension.RegistServlet");
    }

    //��ȡservet
    public static Servlet getServlet(String url) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if(null == url || url.trim().equals("")){
             return null;
        }

        String name = servletContext.getMapping().get(url);
        String servletName = servletContext.getServlet().get(name);
        Class<?> clz = Class.forName(servletName);
        return (Servlet)clz.newInstance();
    }

}
