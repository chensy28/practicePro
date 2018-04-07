package com.csy.classloader;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年03月02日 下午21:58
 *
 * @author csypc
 * @version 1.0
 */
public class Demo1 {
    public static void main(String[] args) throws Exception{
        /*A a = new A();
        A a1 = new A();*/
        //类中的静态变量、静态方法、静态块都是在类加载的时候加载的，并且只在类加载的加载一次
       /* System.out.println("Demo1 main方法！"+ A.width);
        A.show();*/

        //（4）初始化一个类时，如果发现该类的父类没有初始化时，先初始化父类
        //构造函数的执行，先执行父类的构造函数，再执行子类的构造函数
        //B b = new B();

        //类的主动引用（一定会发生类的初始化）
        //A a1 = new A();  (1)new一个对象
        //System.out.println(A.width);
        //A.show();
        //A a = new A();
        //System.out.println(A.var); (2)调用静态方法、静态变量（除了final常量）
        //Class clazz = Class.forName("com.csy.classloader.A"); (3)进行反射调用时


        //类的被动引用（不会发生类的初始化）
        //System.out.println(B.width);(1)档访问一个静态域时，只有
        //声明这个域的类才会初始化，比如：子类B调用A的静态变量width时，只会初始化A
       // System.out.println(B.bWidth);
        //A[] as = new A[12];  （2）通过数组定义类的引用，不会触发此类的初始化
        System.out.println(A.var);//引用常量不会触发此类的初始化（常量在编译阶段就存入调用类的常量池中了）
    }
}

class A{

    public static int width = 100;
    public static final int var = 100;
    static {
        System.out.println("静态初始化A！");
        width = 300;
    }

    public A(){
        System.out.println("创建A类的对象！");
    }

    public static void show(){
        System.out.println("静态方法show()");
    }
}

class B extends A{
    public static int bWidth = 100;
    static {
        System.out.println("静态初始化B！");
    }

    public B(){
        System.out.println("创建B类的对象！");
    }
}


