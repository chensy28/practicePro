package com.csy.classloader;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月04日 下午00:23
 *
 * @author csypc
 * @version 1.0
 */
public class Demo2 {
    public static void main(String[] args) {
        //AppClassLoader 系统类加载器
        System.out.println(ClassLoader.getSystemClassLoader());
        //ExtClassLoader 扩展类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        //引导类加载器，是原生代码实现的，并不继承ClassLoader
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        //双亲委派机制：当接到类加载的任务时，加载器首先将加载任务委派给父加载器，依次追朔，直到爷爷最高辈的。
        //如果父加载器能加载，就由父加载器执行，否则再由当前加载器加载。
        //双亲委派机制为了保证java核心库的安全
        System.out.println("------------------------");
        String str = "yyysss";
        System.out.println(str.getClass().getClassLoader());
        System.out.println(str);
    }
}
