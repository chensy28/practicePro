package com.csy.arraylist;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/12/24.
 * Time:22:20.
 */
public class ArrayListTest {
    Object []objects = new  Object[3];
    public static int  size;
    private int index;
    public void add(Object obj){
        Integer length = objects.length;
        //如果数组长度超过了原来的数组大小，则进行扩充
        if(index == length){
            //按两倍大小进行扩充
            Object [] tempObject = new Object[2*objects.length];
            //调用方法将原数组复制到临时数组（将原数组复制到目标数组，注意参数中length指的是原数组长度）
            System.arraycopy(objects,0,tempObject,0,length);
            //把目标数据的引用付给原数组
            objects = tempObject;
            objects[index] = obj;
            index ++ ;
        }else{
            objects[index] = obj;
            index ++ ;
        }
    }

    public Object get(int index){
        return objects[index];
    }

    public int size(){
        return index;
    }
}
