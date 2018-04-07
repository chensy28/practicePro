package com.csy.http.basic;

/**
 * 项目名称：
 * 类名称：
 * 类描述：将请求响应封装成Servlet
 * 创建时间：2016年04月12日 下午21:20
 *
 * @author csypc
 * @version 1.0
 */
public class Servlet {
    public void service(Request request ,Response response){

        response.createHead(200);
        String context = "<html><head><title>response响应ss封装</title></head><body>12ssss</body></html>";
        response.print(context);
    }
}
