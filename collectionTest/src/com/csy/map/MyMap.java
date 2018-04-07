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

        //�������ظ�,�����ظ��ļ������ȡ����ֵ
        for(int i=0;i<size;i++){
            if(entityNodes[i].getKey().equals(key)){
                entityNodes[i].setValue(value);
                return ;
            }
        }
        //������β�����
        EntityNode e = new EntityNode(key,value);
         /* entityNodes[size] = new EntityNode();
          entityNodes[size].setKey(key);
          entityNodes[size].setValue(value);*/
        entityNodes[size] = e;
        size++;
    }

    public Object get(Object key){
        //�������ݣ��ҵ�ָ������Ӧ��ֵ
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
