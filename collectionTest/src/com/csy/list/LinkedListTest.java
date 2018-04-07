package com.csy.list;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/9.
 * Time:8:30.
 * detail:˫�˶���ʵ��
 */
public class LinkedListTest {
    private Node first;
    private Node last;
    private int size;

    public int size(){
        return size;
    }

    //������β����ӽ��
    public void add(Object obj){
        Node newNode = new Node();
        if(null == first){
            newNode.setData(obj);
            newNode.setPrev(null);
            newNode.setNext(null);

            //��һ�����ʱ�����ǵ�һ���ڵ㡢�������һ���ڵ�
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

    //��ȡָ��λ���ϵ�ֵ
    public Object get(int index){
        rangeCheck(index);
        //Node temp = null;
        //��ͷ�������
        /*if(first != null){
            temp = first;
            for(int i=0;i<index;i++){
                temp = temp.getNext();
            }
        }*/
        //�Ӻ���ǰ����
        /*if(last != null){
            temp = last;
            for(int i=size - 1;i > index;i--){
                temp = temp.getPrev();
            }
        }*/
        //return temp == null ? null : temp.getData();
        return node(index) == null ? null : node(index).getData() ;
    }

    //��ȡָ��λ���ϵĽ��
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

    //�Ƴ�ָ��λ�õĽ��
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


    //�±귶Χ���
    private void rangeCheck(int index){
        try {
            if (index <0 || index >= size){
                throw new Exception();
            }
        }catch (Exception e){
            System.out.print(e.getStackTrace());
        }
    }

    //��ָ��λ������ӽ��
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

