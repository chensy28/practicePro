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
 * ��Ŀ���ƣ�springbasic
 * �����ƣ���̬��ʼ��������
 * ������������
 * ����ʱ�䣺2016��01��19�� ����13:12
 *
 * @author csypc
 * @version 1.0
 */
public class demo2 {
    public static void main(String[] args) {
        //����������ת��
        Set<Long> timeSet = Sets.newHashSet();
        timeSet.add(15254111L);
        timeSet.add(551512222525L);
        timeSet.add(556665L);

        //��ʱ���ת��Ϊָ����ʽ���ַ���
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
        //��̬��ʼ��
        List<String> list = Lists.newArrayList("a","b","c");
        System.out.println(list.size());
        return list;
    }

    public static List filter(List list){
        //�Լ��Ͻ��й���
        Collection<String> dealList = Collections2.filter(list, new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                //ҵ����������ַ���(ȡ)
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
