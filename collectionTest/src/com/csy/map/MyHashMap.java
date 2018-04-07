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
    //hashMap�ĵײ�ʵ��������+���� ,û������Ԫ�ض���һ������
    private LinkedListTest[] arr = new LinkedListTest[7];
    private int size;

    public void put(Object key,Object value){
        EntityNode e = new EntityNode(key,value);
        int hashCode = key.hashCode();
        int pos = hashCode % arr.length;
        //�ж�λ�����Ƿ����Ԫ�أ��������ڣ����ȴ���һ�����б�������ԭ�����������
        if(arr[pos] == null){
            LinkedListTest linked = new LinkedListTest();
            arr[pos] = linked;
            arr[pos].add(e);
        }else{
            //�������ظ���������ͬ������Ҫ��ֵ���и���
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
