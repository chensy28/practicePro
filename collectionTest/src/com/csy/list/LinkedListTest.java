package com.csy.list;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/9.
 * Time:8:30.
 * detail:双端队列实现
 */
public class LinkedListTest {
    private Node first;
    private Node last;
    private int size;

    public int size(){
        return size;
    }

    //在链表尾部添加结点
    public void add(Object obj){
        Node newNode = new Node();
        if(null == first){
            newNode.setData(obj);
            newNode.setPrev(null);
            newNode.setNext(null);

            //第一个结点时，既是第一个节点、又是最后一个节点
            first = newNode;
            last = newNode;
        }else{
            newNode.setData(obj);
            newNode.setPrev(last);
            newNode.setNext(null);

            last.setNext(newNode);
            last = newNode;

        }
        size++;
    }

    //获取指定位置上的值
    public Object get(int index){
        rangeCheck(index);
        //Node temp = null;
        //从头往后便利
        /*if(first != null){
            temp = first;
            for(int i=0;i<index;i++){
                temp = temp.getNext();
            }
        }*/
        //从后往前遍历
        /*if(last != null){
            temp = last;
            for(int i=size - 1;i > index;i--){
                temp = temp.getPrev();
            }
        }*/
        //return temp == null ? null : temp.getData();
        return node(index) == null ? null : node(index).getData() ;
    }

    //获取指定位置上的结点
    private Node node(int index){
        Node node = null;
        if(first != null){
            node = first;
            for(int i=0;i<index;i++){
                node = node.getNext();
            }
        }
        return node;
    }

    //移除指定位置的结点
    public void remove(int index){
        rangeCheck(index);
        Node node = node(index);
        if(node != null){
            Node up = node.getPrev();
            Node down = node.getNext();
            up.setNext(down);
            down.setPrev(up);
            size -- ;
        }
    }


    //下标范围检查
    private void rangeCheck(int index){
        try {
            if (index <0 || index >= size){
                throw new Exception();
            }
        }catch (Exception e){
            System.out.print(e.getStackTrace());
        }
    }

    //在指定位置上添加结点
    public void add(int index,Object object){
        rangeCheck(index);
        Node node = node(index);
        if(node != null){
            Node up = node.getPrev();
           // Node down = node.getNext();

            Node newNode = new Node();
            node.setPrev(newNode);
            up.setNext(newNode);

            newNode.setData(object);
            newNode.setNext(node);
            newNode.setPrev(up);

            size ++ ;
        }
    }

    public static void main(String []args){
        LinkedListTest listTest = new LinkedListTest();
       /* listTest.add("aaa");
        listTest.add("bbb");
        listTest.add("ccc");*/
        //listTest.remove(1);
        listTest.add(0,"EEE");
        for(int i=0 ;i<listTest.size();i++) {
            System.out.println(listTest.get(i));
        }
    }
}

