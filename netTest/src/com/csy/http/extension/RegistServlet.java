package com.csy.http.extension;

/**
 * 项目名称：
 * 类名称：
 * 类描述：
 * 创建时间：2016年04月12日 下午23:01
 *
 * @author csypc
 * @version 1.0
 */
public class RegistServlet extends Servlet {

    @Override
    public void doGet(Request request, Response response) {

    }

    @Override
    public void doPost(Request request, Response response) {
        response.createHead(200);
        String context = "<html><head><title>注册页面</title></head><body>注册成功</body></html>";
        response.print(context);
    }
}
