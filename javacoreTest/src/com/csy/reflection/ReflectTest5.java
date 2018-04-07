package com.csy.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：反射解析泛型
 * 创建时间：2016年02月21日 下午10:30
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
        //获取方法中参数泛型的信息
        //Type[] typeArr = method.getGenericParameterTypes();
        Type[] typeArr = method.getGenericParameterTypes();
        //获取返回的参数类型
        Type returnType = method.getGenericReturnType();

        for (Type type : typeArr){
            //System.out.println(type.getTypeName());
            if(type instanceof ParameterizedType){
                //获取实际的泛型参数(上转型对象)
                //Type[] getActualTypeArguments();
                //【注意】无论<>中有几层<>嵌套，这个方法仅仅脱去最外层的<>之后剩下的内容就作为这个方法的返回值。
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
