package com.csy.http.util;

/**
 * 项目名称：
 * 类名称：
 * 类描述：
 * 创建时间：2016年04月13日 下午21:39
 *
 * @author csypc
 * @version 1.0
 */
public class Person {
    private String name;
    private int age;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
