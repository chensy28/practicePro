package com.csy.arraylist;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2015/12/24.
 * Time:22:20.
 */
public class ArrayListTest {
    Object []objects = new Object[3];
    public static int size;
    private int index;
    public void add(Object obj){
        Integer length = objects.length;
        //������鳤�ȳ�����ԭ���������С�����������
        if(index == length){
            //��������С��������
            Object [] tempObject = new Object[2*objects.length];
            //���÷�����ԭ���鸴�Ƶ���ʱ���飨��ԭ���鸴�Ƶ�Ŀ�����飬ע�������lengthָ����ԭ���鳤�ȣ�
            System.arraycopy(objects,0,tempObject,0,length);
            //��Ŀ�����ݵ����ø���ԭ����
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
