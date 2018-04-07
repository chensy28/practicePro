package com.csy.guava;

import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.multiset.HashMultiSet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 项目名称：springbasic
 * 类名称：demo6
 * 类描述：Multset :无序+可重复
 * 创建时间：2016年01月20日 下午23:04
 *
 * @author csypc
 * @version 1.0
 */
public class demo6 {
    public static void main(String[] args) {

        //统计单词出现的次数
        String str = "returns the number of occurrences of the given object currently in the multiSet";

        String []arr = str.split(" ");
        //无序+可重复
        MultiSet<String> set = new HashMultiSet<>();
        for(int i =0;i<arr.length;i++){
            set.add(arr[i]);
        }

        //将set变为不可重复的，唯一的值
        Set<String> tempset = set.uniqueSet();
        for(String s : tempset){
            System.out.println(s+"出现"+set.getCount(s)+"次");
        }

        //使用map存储，map键不可重复，若有键有相同的，键对应的值会被更新
       /* Map<String,Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++) {
            map.put(arr[i], set.getCount(arr[i]));
        }

        //将map转换为set进行遍历
        Set set1 = map.keySet();
        Iterator it = set1.iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            System.out.println(key+"出现"+map.get(key)+"次");
        }*/

    }
}
