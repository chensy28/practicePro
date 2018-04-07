package com.csy.linklist;

/**
 * Created with IntelliJ IDEA.
 * User:juzi 陈
 * Date:2015/12/24.
 * Time:22:20.
 */
public class LinkListTest {
    public static int size ;
    private int index;
    private Node head;
    private Node tail;

    public LinkListTest(int index, Node head,Node tail) {
        this.index = index;
        this.head = head;
        this.tail = tail;
    }

    public LinkListTest(){
        head = null;
        /*tail = new Node();

        head = tail;*/
        /*head.setNext(null);*/
    }

    public void add(Node src){
         /*if(null == head.getNext()){
             head.setNext(src);
             head.getNext().setNext(null);
         }else{
             Node temp = head;
             for(int i = 0 ;i <= index+1;i++){
                 if(i == index+1) {
                     temp = src;
                     temp.setNext(null);
                     break;
                 }
                 temp = temp.getNext();
             }
         }
        index ++ ;*/

        if(null == head){
            head = src;
            tail = src;
            src.setNext(null);
        }else {
            tail.setNext(src);
            tail = src;
            src.setNext(null);
        }
        index ++ ;

    }

    public Node get(int index){
        for(int i = 0;i < index; i++){
            if(null != head.getNext()){
               head = head.getNext();
            }
        }
        return head;
    }
    public int size(){
        return index;
    }
}
