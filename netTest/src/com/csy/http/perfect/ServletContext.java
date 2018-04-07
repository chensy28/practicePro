package com.csy.http.perfect;


import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：
 * 类名称：
 * 类描述：上下文
 * 创建时间：2016年04月12日 下午22:24
 *
 * @author csypc
 * @version 1.0
 */
public class ServletContext {
    //为每个servlet起一个别名
    //private Map<String, Servlet> servlet; //键值对中存对象比较耗空间，可存包路径，然后通过反射

    private Map<String,String> servlet;

    //将请求url与别名映射
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
