package com.csy.list;

/**
 * Created with IntelliJ IDEA.
 * User:juzi
 * Date:2016/1/13.
 * Time:21:24.
 */
public class Node {
    Node prev;
    Object data;
    Node next;

    public Node() {

    }

    public Node(Node prev, Object data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
