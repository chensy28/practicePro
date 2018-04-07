package com.csy.commons;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;

/**
 * 项目名称：springbasic
 * 类名称：demo1
 * 类描述：Predicate、transformer
           断言处理
 * 创建时间：2016年01月24日 下午14:48
 *
 * @author csypc
 * @version 1.0
 */
public class demo1 {
    public static void main(String[] args) {
        //判断相等的谓词
        Predicate predicate = EqualPredicate.equalPredicate("aa");
        boolean isEqual = predicate.evaluate("aa");
        System.out.println(isEqual);

        //判断是否为空的谓词
        Predicate predicate1 = NotNullPredicate.notNullPredicate();
        Integer i = null;
        System.out.println(predicate1.evaluate(i));


    }
}
