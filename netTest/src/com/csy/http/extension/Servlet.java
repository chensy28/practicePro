package com.csy.http.extension;

/**
 * 项目名称：
 * 类名称：
 * 类描述：将请求响应封装成Servlet
 * 创建时间：2016年04月12日 下午21:20
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
