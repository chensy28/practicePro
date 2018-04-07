package com.csy.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;

/**
 * 项目名称：springbasic
 * 类名称 ：使用javassist创建新类
 * 类描述：
 * 创建时间：2016年02月24日 下午23:36
 *
 * @author csypc
 * @version 1.0
 */
public class Demo {
    public static void main(String[] args) throws Exception{
     //   ClassPool classPool = new ClassPool();
        //classPool.appendSystemPath();
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("UserTest");

        //添加变量
        //CtField field1 = CtField.make("private string name='zhangsan';",ctClass);
        CtField field2 = CtField.make("private int age=10;",ctClass);

        //ctClass.addField(field1);
        ctClass.addField(field2);

        //添加方法
       // CtMethod method1 = CtMethod.make("private String getName(){return this.name;};",ctClass);
        //CtMethod method2 = CtMethod.make("private void setName(String name){this.name=name;};",ctClass);

        /* CtMethod method1 = CtMethod.make("private int getAge(){return this.age;};",ctClass);
        CtMethod method2 = CtMethod.make("private void setAge(int age){this.age=age;};",ctClass);

        ctClass.addMethod(method1);
        ctClass.addMethod(method2);*/

        //添加构造方法

        ctClass.writeFile("c:/myjava");
        System.out.println("生成类，成功");

    }
}
