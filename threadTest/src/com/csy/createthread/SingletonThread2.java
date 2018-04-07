package com.csy.createthread;

/**
 * 项目名称：
 * 类名称：单例模式 饿汉式
 * 类描述：
 * 创建时间：2016年03月11日 下午00:36
 *
 * @author csypc
 * @version 1.0
 */
public class SingletonThread2 {
    public static void main(String[] args) {
       /* SingleTon singleTon1 = SingleTon.getInstance();
        SingleTon singleTon2 = SingleTon.getInstance();
        SingleTon singleTon3 = SingleTon.getInstance();

        System.out.println(singleTon1.hashCode());
        System.out.println(singleTon2.hashCode());
        System.out.println(singleTon3.hashCode());*/

        SingleTonTest singleTon1 = SingleTonTest.getInstance();
        SingleTonTest singleTon2 = SingleTonTest.getInstance();
        SingleTonTest singleTon3 = SingleTonTest.getInstance();

        System.out.println(singleTon1.hashCode());
        System.out.println(singleTon2.hashCode());
        System.out.println(singleTon3.hashCode());


    }
}

class SingleTon{
    //声明静态的变量，并且进行初始化
    private static SingleTon singleTon = new SingleTon(); //--->与懒汉式区别之处
    //对外声明私有构造器
    private SingleTon(){}

    //对外提供访问变量的公有方法，因为实例在类加载时就被创建了，所以直接返回
    public static SingleTon getInstance(){
        return singleTon;   //--->与懒汉式区别之处
    }
}

//内部类写法
class SingleTonTest{
    static class Nested{
        private static SingleTonTest singleTonTest = new SingleTonTest();
    }

    private SingleTonTest(){}

    public static SingleTonTest getInstance(){
        return Nested.singleTonTest;
    }
}
