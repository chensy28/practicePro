package com.csy.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * ��Ŀ���ƣ�
 * �����ƣ�
 * ��������URL������ʹ��
 * ����ʱ�䣺2016��03��30�� ����21:35
 *
 * @author csypc
 * @version 1.0
 */
public class UrlBasic {
    public static void main(String[] args) throws MalformedURLException {
        //������·������(��δָ��Э�飬���׳�MalformedURLException)
        URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=ab");
        //URL url = new URL("http://www.baidu.com:80");

        //���·��

        //��ȡ������Ϣ
        System.out.println("Э�飺"+url.getProtocol());
        System.out.println("������:"+url.getHost());
        System.out.println("�˿ڣ�"+url.getPort());
        System.out.println("ê�㣺"+url.getRef());
        System.out.println("��Դ��"+url.getFile());
        System.out.println("���·����"+url.getPath());
        System.out.println("������"+url.getQuery());  //����ê�㣬����null��������ê�㣬������ȷ

    }
}
