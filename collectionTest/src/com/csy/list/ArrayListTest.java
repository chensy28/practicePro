package com.csy.list;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/8.
 * Time:8:25.
 */
public class ArrayListTest {
    private Object[] objects;
    private int size;

    public ArrayListTest() {
        this(3);
    }
    public ArrayListTest(int initialCapacity){
        objects = new Object[initialCapacity];
    }

    //��β����Ӷ���
    public void add(Object obj){
        if(size == objects.length){
            //����
            ensureCapacity();
            objects[size++] = obj;
        }else{
            objects[size++] = obj;
        }
    }

    //��ָ����λ������Ӷ���
    public void add(int index,Object obj) throws Exception{
        rangeCheck(index);
        ensureCapacity();
        int lenth = size - index;
        System.arraycopy(objects,index,objects,index+1,lenth);
        size++;
        objects[index] = obj;
    }
    public void ensureCapacity(){
        Object [] newArray = new Object[size*2];
        for(int i=0;i<objects.length;i++){
            newArray[i] = objects[i];
        }
        //��ԭ��������ָ���µ�����
        objects = newArray;
    }

    //��ȡָ��λ���ϵ�Ԫ��
    public Object get(int index) throws Exception{
        if(index < 0 || index >= size){
            throw new Exception();
        }
        return objects[index];
    }

    public int size(){
        return size;
    }

    //�޸�ָ��λ�õ�Ԫ��
    public void set(int index,Object obj) throws Exception{
        rangeCheck(index);
        objects[index] = obj;
    }

    //ɾ��ָ��λ�õĶ���
    public void remove(int index) throws Exception{
        rangeCheck(index);
        int lenth = size - index - 1;
        if(index >= 0){
            //��ͬһ�������̨����������ǰ�ƶ�һ��λ��
            System.arraycopy(objects,index+1,objects,index,lenth);
            //�����һ��Ԫ����Ϊnull
            objects[--size] = null;
        }
    }

    //ɾ��ָ���Ķ���
    public void remove(Object obj) throws Exception{
        for(int i=0;i<size;i++){
            if(objects[i] == obj){
                //���Ҷ�������Ӧ��λ��
                remove(i);
            }
        }
    }

    private void rangeCheck(int index) throws Exception{
        if (index >= size)
            throw new Exception();
    }

    public static void main(String []args) throws Exception{
        //ArrayListTest test = new ArrayListTest();

        List test = new ArrayList();
        test.add("aaa");
        test.add("bbb");
        test.add("ccc");
        test.add("ddd");
        //System.out.print(test.size()+":"+test.get(3));
        //test.remove(2);
        //test.remove("aaa");
        //test.add(1,"fff");
        //test.set(1,"ppp");

        //ʹ��Iterator����
        Iterator it = test.iterator();
        while(it.hasNext()){
            String str = (String)it.next();
            System.out.println(str);
        }

        //ʹ�ô�ͳforѭ������
       /* for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }*/
       /* System.out.print(test.size() + ":" + test.get(1));*/
    }
}
