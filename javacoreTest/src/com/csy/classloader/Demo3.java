package com.csy.classloader;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月04日 下午21:04
 *
 * @author csypc
 * @version 1.0
 */
public class Demo3 {
    public static void main(String[] args) throws Exception{
        //同一个类被不同的加载器加载的类，是不一样的类
        FileSytemLoader loader = new FileSytemLoader("H:/myjavatest");
        FileSytemLoader loader2 = new FileSytemLoader("H:/myjavatest");
        Class<?> c = loader.findClass("com.csy.HelloWorld");
        Class<?> c2 = loader2.findClass("com.csy.HelloWorld");  //此处同一个加载器加载同一个类，出错(jdk8)
                                                               // attempted  duplicate class definition for name: "HelloWorld"
        //Class<?> c3 = loader2.findClass("com.csy.HelloWorld");
        System.out.println(c.hashCode());
        System.out.println(c2.hashCode());
       // System.out.println(c3.hashCode());

    }
}
