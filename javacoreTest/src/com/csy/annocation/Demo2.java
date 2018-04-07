//@MyAnnotation
package com.csy.annocation;

/**
 * 项目名称：springbasic
 * 类名称：Demo2
 * 类描述：引用自定义注解 @Target使用
 * 创建时间：2016年01月27日 下午23:19
 *
 * @author csypc
 * @version 1.0
 */
@MyAnnotation                                  //作用于类
public class Demo2 {
    @MyAnnotation(value="aa")                              //作用于成员变量
    private String ano;
    @MyAnnotation (arr={"dd","gg"})                            //作用于方法

    public void show( @MyAnnotation String s){  //作用于参数

        @MyAnnotation2                         // 作用于另一个注解
        @MyAnnotation                         //作用于成员变量
         String str;
    }

}
