package com.csy.classloader;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月05日 下午07:40
 *
 * @author csypc
 * @version 1.0
 */
public class Demo4 {
    public static void main(String[] args) throws Exception{
        int a = 3;
       /* System.out.println(Integer.toHexString(a | 0xff));  //进行或运算，返回16进制表示的字符串
        System.out.println(Integer.toBinaryString(a & 0xff));//进行与运算
        System.out.println(Integer.toBinaryString(a ^ 0xff));//进行取反运算*/

        //加密后出现java.lang.ClassFormatError: Incompatible magic value，因为class结构改变了，所以需要解密
        //类加载按原来的规则加载class,class加密后格式变了，所以加载不了
      /*  FileSytemLoader loader = new FileSytemLoader("H:/myjavatest");
        Class<?> c = loader.findClass("com.csy.temp.HelloWorld");
        System.out.println(c.hashCode());*/

        DncryptClassLoader loader = new DncryptClassLoader("H:/myjavatest");
        Class<?> c = loader.findClass("com.csy.temp.HelloWorld");
        System.out.println(c.hashCode());

    }
}
