package com.csy.nestedclass;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：内部类介绍
 * 创建时间：2016年03月05日 下午23:51
 *
 * @author csypc
 * @version 1.0
 */
public class Introduce {

    //内部类仍然是一个独立的类，在编译之后内部类会被编译成独立的.class文件，但是前面冠以外部类的类名和$符号
    //内部类可以用修饰符public、private、static等修饰，相当于外部类的成员

    //---------静态内部类------------------
    static class StaticClass{

    }

    // --------非静态内部类------------------
    //普通内部类
    private class CommonClass{

    }

    //方法内部类
    public void methodNestedClass(){
        class MethodClass{

        }

        //匿名内部类(也是方法内部类)
        Run run = new Run() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
    }

}
