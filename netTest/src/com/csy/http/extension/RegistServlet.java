package com.csy.http.extension;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��04��12�� ����23:01
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
        String context = "<html><head><title>ע��ҳ��</title></head><body>ע��ɹ�</body></html>";
        response.print(context);
    }
}
