package com.csy.http.extension;


/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ����������¼servlet
 * ����ʱ�䣺2016��04��12�� ����22:58
 *
 * @author csypc
 * @version 1.0
 */
public class LoginServlet extends Servlet {

    @Override
    public void doGet(Request request, Response response) {
        response.createHead(response.getCode());
        String context = "<html><head><title>��¼ҳ��</title></head><body>��¼�ɹ�</body></html>";
        response.print(context);
    }

    @Override
    public void doPost(Request request, Response response) {

    }
}
