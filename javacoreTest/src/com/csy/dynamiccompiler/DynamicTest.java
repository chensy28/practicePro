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
 * 项目名称：springbasic
 * 类名称：
 * 类描述：动态编译
 * 创建时间：2016年02月21日 下午22:00
 *
 * @author csypc
 * @version 1.0
 */
public class DynamicTest {
    public static void main(String[] args) throws Exception{

        //获取JavaCompiler
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        int result = javaCompiler.run(null,null,null,"E:/HelloWorld.java");//指定编译java文件地址,前三个参数为null，使用默认的值
        System.out.println(result == 0 ? "编译s成功！":"编译失败！" );


        //启动新的进程运行
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp E:/ HelloWorld");

        //获取子进程的输入流
        InputStream inputStream = process.getInputStream();
        //使用缓冲字符流(InputStreamReader 是字节流通向字符流的桥梁)
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String info = "";
        while ((info = reader.readLine()) != null){
            System.out.println("动态编译、执行"+info);
        }


        //使用反射运行编译好的类
        URL[] urls = new URL[]{new URL("file:/" + "E:/")};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class classl = classLoader.loadClass("HelloWorld");
        Method method = classl.getDeclaredMethod("main", String[].class);
        String[] argsl = {null};
        method.invoke(classl.newInstance(), argsl);

    }
}
