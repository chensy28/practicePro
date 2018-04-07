package com.csy.reflection;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年02月07日 下午15:15
 *
 * @author csypc
 * @version 1.0
 */
public class ReflectTest {
    public static void main(String[] args) {
        //获取class的方式
        try {

            //同一类型的对象共享同一个class
            Class clazz = Class.forName("com.csy.reflection.Demo");          //使用forName()获取指定名称的类
            Class clazz2 = Class.forName("com.csy.reflection.Demo");
            System.out.println(clazz.hashCode()+"\n"+clazz2.hashCode());

            //使用.class获取Class（获取类的Class对象）
            Class clazz3 = ReflectTest.class;
            System.out.println(clazz3.hashCode()+":"+clazz3.getName());

            Class clazz4 = Class.class;
            System.out.println(clazz4.hashCode()+":"+clazz4.getName());

            //获取接口的Class对象
            Class clazz5 = Class.forName("com.csy.reflection.Demo2");
            System.out.println(clazz5.hashCode()+":"+clazz5.getName());

            //获取注解的Class对象
            Class clazz6 = Class.forName("com.csy.reflection.MyAnnotation");
            System.out.println(clazz6.hashCode()+":"+clazz6.getName());

            //获取基本类型的Class对象
            Class clazz7 = int.class;
            System.out.println(clazz7.hashCode()+":"+clazz7.getName());

            //相同维数且类型相同的数组Class对象相同
            int []aa = new int[2];
            int []bb = new int[23];
            System.out.println(aa.getClass().hashCode());
            System.out.println(bb.getClass().hashCode());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


