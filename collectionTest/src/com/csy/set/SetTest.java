package com.csy.set;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/14.
 * Time:7:52.
 */
public class SetTest {
    public static void main(String []args){
        //set�ĵײ�ṹ��map�����ʱ���ǽ���ӵ�ֵ��Ϊkey����map����ȡʱ������iterator����key�ļ���
        Set set = new HashSet<>();  //����ָ��������Set<String> Ĭ��ΪObject����
        set.add("aa");
        set.add(new Integer(1));
        set.add("cc");

        /*Set set2 = new HashSet<>();
        set2.add("bb");
        set2.add("ee");*/

       // set.retainAll(set2); �󽻼�   ָ���ļ��ϲ���Ϊnull
       // System.out.println(set.contains("aa"));  �Ƿ����
        //set.clear();
        //set.addAll(set2); �󲢼�   ָ���ļ��ϲ���Ϊnull

      /*Iterator<String> iterator = set.iterator();  //ʹ��iterator��������
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }*/
       /* Object [] arr = set.toArray();    //ʹ��for��ǿ����
        for(Object obj : arr){
            System.out.print(obj+" ");
        }*/
        for(Object obj : set){            //ֱ�ӽ�set���б���
            System.out.print(obj+" ");
        }


//        System.out.println(set.size());
        //List list; //�̳�Collection�ӿ�
       // Map map = new HashMap<>();   //û�м̳�Collection�ӿ�
    }
}