package com.csy.map;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/11.
 * Time:0:11.
 */
public class MyMap {
    private EntityNode [] entityNodes = new EntityNode[100];
    private int size;

    public void put(Object key,Object value){

        //键不能重复,若有重复的键，则采取更新值
        for(int i=0;i<size;i++){
            if(entityNodes[i].getKey().equals(key)){
                entityNodes[i].setValue(value);
                return ;
            }
        }
        //在数组尾部添加
        EntityNode e = new EntityNode(key,value);
         /* entityNodes[size] = new EntityNode();
          entityNodes[size].setKey(key);
          entityNodes[size].setValue(value);*/
        entityNodes[size] = e;
        size++;
    }

    public Object get(Object key){
        //遍历数据，找到指定键对应的值
        for(int i=0;i<size;i++){
            if(entityNodes[i].getKey().equals(key)){
                return entityNodes[i].getValue();
            }
        }
        return null;
    }

    public static void main(String []args){
        MyMap map = new MyMap();
        map.put("1","aaa");
        map.put("2","bbb");
        System.out.print(map.get("1"));
    }
}

class EntityNode{
    Object key;
    Object value;

    public EntityNode() {
    }

    public EntityNode(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
