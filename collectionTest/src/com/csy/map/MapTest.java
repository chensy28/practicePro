package com.csy.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/10.
 * Time:21:23.
 */
public class MapTest {

    public static void main(String []args) {
        Map<Object, Object> map = new HashMap<>();
        map.put("1","aa");
        map.put("2","bb");

        //�Ƿ���������Ƿ����ֵ
        boolean ifContainKey = map.containsKey("1");
        boolean ifContainValue = map.containsValue("xx");

        //��Ԫ�ش�������ɾ���������ڴ��л�����
        /*String str = (String)map.remove("1");
        System.out.println(str);*/
        String str = (String)map.get("1");
        map.clear();
        System.out.println(str);
        System.out.println((String)map.get("1"));
        //System.out.println((String)null); ok
    }

}
