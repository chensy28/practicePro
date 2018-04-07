package com.csy.http.extension;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;

import java.util.Map;

/**
 * 项目名称：
 * 类名称：
 * 类描述：产生上下文
 * 创建时间：2016年04月12日 下午23:04
 *
 * @author csypc
 * @version 1.0
 */
public class WebApp {
    private static ServletContext servletContext;
    static {
        /*private Map<String, Servlet> servlet;

        //将请求url与别名映射
        //  /login --> "login"
        //  /log   --> "login"
        private Map<String,String> mapping;*/
        servletContext = new ServletContext();
        Map<String,String> mapping = servletContext.getMapping();
        mapping.put("/login", "login");
        mapping.put("/log", "login");
        mapping.put("/regist", "regist");

        //若需要修改映射，需要对程序进行编译执行，可将映射信息放入配置文件
        Map<String,String> servletMap = servletContext.getServlet();
        servletMap.put("login","com.csy.http.extension.LoginServlet");
        servletMap.put("regist","com.csy.http.extension.RegistServlet");
    }

    //获取servet
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
