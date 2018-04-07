package com.csy.map;

import com.csy.list.LinkedListTest;
import com.csy.list.Node;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/13.
 * Time:21:00.
 */
public class MyHashMap {
    //hashMap的底层实现是数组+链表 ,没个数据元素都是一个链表
    private LinkedListTest[] arr = new LinkedListTest[7];
    private int size;

    public void put(Object key,Object value){
        EntityNode e = new EntityNode(key,value);
        int hashCode = key.hashCode();
        int pos = hashCode % arr.length;
        //判断位置上是否存在元素，若不存在，则先创建一个空列表，若存在原来的链表添加
        if(arr[pos] == null){
            LinkedListTest linked = new LinkedListTest();
            arr[pos] = linked;
            arr[pos].add(e);
        }else{
            //键不能重复，若键相同，则需要讲值进行覆盖
            for(int i=0;i<arr[pos].size();i++){
                EntityNode node = (EntityNode)arr[pos].get(i);
                if(node.getKey().equals(key)){
                    node.setValue(value);
                    return ;
                }
            }
            arr[pos].add(e);
        }
        size++;
    }

    public Object get(Object key){
        int hashCode = key.hashCode();
        int pos = hashCode % arr.length;
        LinkedListTest listed = arr[pos];
        if(listed == null){
            return null;
        }
        for(int i=0;i<listed.size();i++){
            EntityNode node = (EntityNode)listed.get(i);
            if(node.getKey().equals(key)){
                return node.getValue();
            }
        }
       return null;
    }

    public int size(){
        return size;
    }

    public static void main(String []args){
        MyHashMap map = new MyHashMap();
        map.put("1","aa");
        map.put("2","bb");
        map.put("3","cc");
        map.put("1","dd");
       // for(int i=1;i<=map.size();i++){
          //  System.out.println(map.get(String.valueOf(i)));
       // }
        System.out.println(map.get("1"));
    }

}
