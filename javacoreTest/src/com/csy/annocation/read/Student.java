package com.csy.annocation.read;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年01月28日 下午21:29
 *
 * @author csypc
 * @version 1.0
 */
@TableAnnotation(tableName = "student")
public class Student {
    //年龄
    @FieldAnnotation(filedName = "AGE",length = 10,isNull = false)
    private int age;

    @FieldAnnotation(filedName = "NAME",length = 5,isNull = true)
    //姓名
    private String name;

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
