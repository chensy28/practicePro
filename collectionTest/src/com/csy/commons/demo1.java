package com.csy.commons;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;

/**
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�demo1
 * ��������Predicate��transformer
           ���Դ���
 * ����ʱ�䣺2016��01��24�� ����14:48
 *
 * @author csypc
 * @version 1.0
 */
public class demo1 {
    public static void main(String[] args) {
        //�ж���ȵ�ν��
        Predicate predicate = EqualPredicate.equalPredicate("aa");
        boolean isEqual = predicate.evaluate("aa");
        System.out.println(isEqual);

        //�ж��Ƿ�Ϊ�յ�ν��
        Predicate predicate1 = NotNullPredicate.notNullPredicate();
        Integer i = null;
        System.out.println(predicate1.evaluate(i));


    }
}
