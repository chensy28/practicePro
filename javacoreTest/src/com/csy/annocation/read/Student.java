package com.csy.annocation.read;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * ��������
 * ����ʱ�䣺2016��01��28�� ����21:29
 *
 * @author csypc
 * @version 1.0
 */
@TableAnnotation(tableName = "student")
public class Student {
    //����
    @FieldAnnotation(filedName = "AGE",length = 10,isNull = false)
    private int age;

    @FieldAnnotation(filedName = "NAME",length = 5,isNull = true)
    //����
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
