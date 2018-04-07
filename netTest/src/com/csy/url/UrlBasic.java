package com.csy.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 项目名称：
 * 类名称：
 * 类描述：URL创建与使用
 * 创建时间：2016年03月30日 下午21:35
 *
 * @author csypc
 * @version 1.0
 */
public class UrlBasic {
    public static void main(String[] args) throws MalformedURLException {
        //按绝对路径创建(若未指定协议，则抛出MalformedURLException)
        URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=ab");
        //URL url = new URL("http://www.baidu.com:80");

        //相对路径

        //获取基本信息
        System.out.println("协议："+url.getProtocol());
        System.out.println("主机名:"+url.getHost());
        System.out.println("端口："+url.getPort());
        System.out.println("锚点："+url.getRef());
        System.out.println("资源："+url.getFile());
        System.out.println("相对路径："+url.getPath());
        System.out.println("参数："+url.getQuery());  //存在锚点，返回null，不存在锚点，返回正确

    }
}
