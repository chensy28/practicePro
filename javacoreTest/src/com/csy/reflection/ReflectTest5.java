package com.csy.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�
 * �������������������
 * ����ʱ�䣺2016��02��21�� ����10:30
 *
 * @author csypc
 * @version 1.0
 */
public class ReflectTest5 {

    public void test1(Map<String,List<String>> map,List<Demo> list){
        System.out.println("test1");
    }

    public List<Demo> test2(){
        System.out.println("test2");
        return null;
    }
    public static void main(String[] args) throws Exception{

        Class clazz = ReflectTest5.class;
        Method method = clazz.getMethod("test1",Map.class,List.class);
        //��ȡ�����в������͵���Ϣ
        //Type[] typeArr = method.getGenericParameterTypes();
        Type[] typeArr = method.getGenericParameterTypes();
        //��ȡ���صĲ�������
        Type returnType = method.getGenericReturnType();

        for (Type type : typeArr){
            //System.out.println(type.getTypeName());
            if(type instanceof ParameterizedType){
                //��ȡʵ�ʵķ��Ͳ���(��ת�Ͷ���)
                //Type[] getActualTypeArguments();
                //��ע�⡿����<>���м���<>Ƕ�ף��������������ȥ������<>֮��ʣ�µ����ݾ���Ϊ��������ķ���ֵ��
                Type[] types = ((ParameterizedType)type).getActualTypeArguments();

                Type type1 = ((ParameterizedType)type).getOwnerType();
                System.out.println("type1:"+type1);

                Type type3 = ((ParameterizedType)type).getRawType();
                System.out.println("type3:"+type3.getTypeName());

                for(Type type2 : types){
                    System.out.println(type2.getTypeName());
                }
            }

           /* System.out.println(returnType);*/
        }
    }
}
