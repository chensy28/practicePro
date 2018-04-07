package com.csy.ref;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/16.
 * Time:22:55.
 */
public class RefTest {
    public static void main(String []args){
        //字符串常量是共享的，不能被回收
        //String str = "hello world";

        //字符串能被回收
        String str = new String("hello world");
        //弱引用管理对象
        WeakReference<String> ref = new WeakReference<>(str);
        System.out.println("gc运行前：" + ref.get());
        //断开引用后，表明是垃圾对象
        str = null;
        //运行垃圾回收器
        System.gc();
        //运行处于挂起终止状态的所有对象的终止方法。
        System.runFinalization();
        System.out.println("gc运行后：" + ref.get());
    }
}
