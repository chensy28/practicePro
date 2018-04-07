package com.csy.dynamiccompiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ����������̬����
 * ����ʱ�䣺2016��02��21�� ����22:00
 *
 * @author csypc
 * @version 1.0
 */
public class DynamicTest {
    public static void main(String[] args) throws Exception{

        //��ȡJavaCompiler
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        int result = javaCompiler.run(null,null,null,"E:/HelloWorld.java");//ָ������java�ļ���ַ,ǰ��������Ϊnull��ʹ��Ĭ�ϵ�ֵ
        System.out.println(result == 0 ? "����s�ɹ���":"����ʧ�ܣ�" );


        //�����µĽ�������
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp E:/ HelloWorld");

        //��ȡ�ӽ��̵�������
        InputStream inputStream = process.getInputStream();
        //ʹ�û����ַ���(InputStreamReader ���ֽ���ͨ���ַ���������)
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String info = "";
        while ((info = reader.readLine()) != null){
            System.out.println("��̬���롢ִ��"+info);
        }


        //ʹ�÷������б���õ���
        URL[] urls = new URL[]{new URL("file:/" + "E:/")};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class classl = classLoader.loadClass("HelloWorld");
        Method method = classl.getDeclaredMethod("main", String[].class);
        String[] argsl = {null};
        method.invoke(classl.newInstance(), argsl);

    }
}
