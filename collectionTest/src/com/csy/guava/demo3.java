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
 * ��Ŀ���ƣ�springbasic
 * �����ƣ�demo3
 * ���������������
 * ����ʱ�䣺2016��01��20�� ����08:26
 *
 * @author csypc
 * @version 1.0
 */
public class demo3 {
    public static void main(String[] args) {
        //��ȡ�ַ��������Ҵ�д
        List<String> list = Lists.newArrayList("ddsfwe","sdfgwss","sswegg");

        //��ȡ�ַ��� Function(F,T) F:�������ͣ�T:��������
        Function<String,String> fun1 = new Function<String, String>() {
            @Override
            public String apply(String s) {  //�������ҵ����
                return s.length() > 5 ? s.substring(0,5):s;
            }
        };
        
        //���ַ�����д
        Function<String,String> fun2 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        //���������
        Function<String,String> fun3 = Functions.compose(fun1,fun2);

        // ת��Ϊ���ϣ�ʹ��guava�е�������д���Ȼ����ת��Ϊ�������ϣ�
        Collection collection = Collections2.transform(list,fun3);
        Iterator it = collection.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
