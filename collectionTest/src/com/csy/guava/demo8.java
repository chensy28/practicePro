package com.csy.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * 项目名称：springbasic
 * 类名称：demo8
 * 类描述：BiMap 键与值都不能重复
 * 创建时间：2016年01月21日 下午08:10
 *
 * @author csypc
 * @version 1.0
 */
public class demo8 {
    public static void main(String[] args) {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","a"); //不强制输入，重复的值会被更新
        biMap.put("1","b");
        biMap.put("2","a");

        /*biMap.forcePut("1","a"); //强制输入(但是出现重复的值不会报错)
        biMap.forcePut("1","b");
        biMap.forcePut("2","c");
*/

        //将键值反转
        BiMap reverse = biMap.inverse();

        //在反转
        BiMap again = reverse.inverse();
        again.clear(); //此处的again、reverse、biMap都是同一个引用，所以清除一个，其它的也被清楚掉
        System.out.println(biMap.entrySet());
        System.out.println(biMap.size());
    }
}
