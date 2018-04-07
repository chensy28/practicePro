package com.csy.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;

/**
 * ��Ŀ���ƣ�springbasic
 * ������ ��ʹ��javassist��������
 * ��������
 * ����ʱ�䣺2016��02��24�� ����23:36
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

        //��ӱ���
        //CtField field1 = CtField.make("private string name='zhangsan';",ctClass);
        CtField field2 = CtField.make("private int age=10;",ctClass);

        //ctClass.addField(field1);
        ctClass.addField(field2);

        //��ӷ���
       // CtMethod method1 = CtMethod.make("private String getName(){return this.name;};",ctClass);
        //CtMethod method2 = CtMethod.make("private void setName(String name){this.name=name;};",ctClass);

        /* CtMethod method1 = CtMethod.make("private int getAge(){return this.age;};",ctClass);
        CtMethod method2 = CtMethod.make("private void setAge(int age){this.age=age;};",ctClass);

        ctClass.addMethod(method1);
        ctClass.addMethod(method2);*/

        //��ӹ��췽��

        ctClass.writeFile("c:/myjava");
        System.out.println("�����࣬�ɹ�");

    }
}
