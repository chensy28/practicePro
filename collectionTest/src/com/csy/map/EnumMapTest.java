package com.csy.map;

import java.util.EnumMap;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/17.
 * Time:9:20.
 */
public class EnumMapTest {
    public static void main(String []args) {
        //枚举map,键是枚举值
        EnumMap<Season,String> map = new EnumMap<Season, String>(Season.class);
        map.put(Season.SPRING,"aa");
        map.put(Season.SUMMARY,"bb");
        System.out.print(map.get(Season.SUMMARY));
    }

    enum Season{
        SPRING,SUMMARY
    }
}
