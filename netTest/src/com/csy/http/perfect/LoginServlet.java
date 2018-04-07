package com.csy.http.perfect;


/**
 * 项目名称：
 * 类名称：
 * 类描述：登录servlet
 * 创建时间：2016年04月12日 下午22:58
 *
 * @author csypc
 * @version 1.0
 */
public class LoginServlet extends Servlet {

    @Override
    public void doGet(Request request, Response response) {
        response.createHead(response.getCode());
        String context = "<html><head><title>登录页面</title></head><body>登录成功</body></html>";
        response.print(context);
    }

    @Override
    public void doPost(Request request, Response response) {

    }
}
