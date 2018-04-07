package com.csy.guava;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import javax.swing.text.html.HTMLDocument;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 项目名称：springbasic
 * 类名称：静态初始化、过滤
 * 类描述：工具
 * 创建时间：2016年01月19日 下午13:12
 *
 * @author csypc
 * @version 1.0
 */
public class demo2 {
    public static void main(String[] args) {
        //将集合类型转换
        Set<Long> timeSet = Sets.newHashSet();
        timeSet.add(15254111L);
        timeSet.add(551512222525L);
        timeSet.add(556665L);

        //将时间戳转换为指定格式的字符串
        Collection<String> dateList = Collections2.transform(timeSet, new Function<Long, String>() {
            @Override
            public String apply(Long aLong) {
                return new SimpleDateFormat("yyyy-MM").format(new Date(aLong)).toString();
            }
        });
        Iterator it = dateList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


    }

    public static List<String> init(){
        //静态初始化
        List<String> list = Lists.newArrayList("a","b","c");
        System.out.println(list.size());
        return list;
    }

    public static List filter(List list){
        //对集合进行过滤
        Collection<String> dealList = Collections2.filter(list, new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                //业务处理，求回文字符创(取)
                return new StringBuffer(s).reverse().toString().equals(s);
            }
        });
        Iterator it = dealList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        return null;
    }
}
