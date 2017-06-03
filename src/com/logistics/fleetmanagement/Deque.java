package com.logistics.fleetmanagement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Tomcio on 2017-05-28.
 */
public class Deque {
    private class Node implements Iterator<Node>{
        String item;
        Node next;
        Node previous;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Node next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }

    private Node firstItem;
    private Node lastItem;
    private int N;

    public Deque() {
        N = 0;
    }

    public boolean isEmpty() {
        if (firstItem == null && lastItem == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return N;
    }

    public void addFirst(String item) {
        if (firstItem == null) {
            Node newNode = new Node();
            newNode.item = item;
            firstItem = newNode;
            lastItem = firstItem;
            N++;

        } else {
            Node newNode = new Node();
            newNode.item = item;
            firstItem.previous = newNode;
            newNode.next = firstItem;
            firstItem = newNode;
            N++;
        }
    }
    public void addLast(String item){
        if(lastItem == null){
            Node newNode = new Node();
            newNode.item = item;
            firstItem = newNode;
            lastItem = firstItem;
            N++;

        }else {
            Node newNode = new Node();
            newNode.item = item;
            newNode.previous = lastItem;
            lastItem.next = newNode;
            lastItem = newNode;
            N++;
        }
    }
    public String removeFirst(){
        String it;
        if(size()==0){
            throw new NoSuchElementException("deque is empty");
        }
        else{
            it = firstItem.item;
            firstItem = firstItem.next;
            N--;

        }return it;
    }
    public String removeLast(){
        String it;
        if(size()==0){
            throw new NoSuchElementException("deque is empty");
        }else{
            it = lastItem.item;
            lastItem = lastItem.previous;
            N--;

        }return it;
    }


}
