package com.csy.guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import javax.swing.text.html.HTMLDocument;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * 项目名称：springbasic
 * 类名称：demo3
 * 类描述：函数组合
 * 创建时间：2016年01月20日 下午08:26
 *
 * @author csypc
 * @version 1.0
 */
public class demo3 {
    public static void main(String[] args) {
        //截取字符串，并且大写
        List<String> list = Lists.newArrayList("ddsfwe","sdfgwss","sswegg");

        //截取字符串 Function(F,T) F:输入类型，T:返回类型
        Function<String,String> fun1 = new Function<String, String>() {
            @Override
            public String apply(String s) {  //将具体的业务处理
                return s.length() > 5 ? s.substring(0,5):s;
            }
        };
        
        //将字符串大写
        Function<String,String> fun2 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        //将函数组合
        Function<String,String> fun3 = Functions.compose(fun1,fun2);

        // 转换为集合（使用guava中的组件进行处理，然后再转换为基本集合）
        Collection collection = Collections2.transform(list,fun3);
        Iterator it = collection.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
