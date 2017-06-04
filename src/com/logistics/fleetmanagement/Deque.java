package com.logistics.fleetmanagement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Tomcio on 2017-05-28.
 */
public class Deque<Item> implements Iterable<Item> {


    @Override
    public Iterator<Item> iterator() {
        return new NodeIterator();
    }

//    @Override
//    public void forEach(Consumer<? super Deque> action) {
//
//    }
//
//    @Override
//    public Spliterator<Deque> spliterator() {
//        return null;
//    }
    private class NodeIterator implements Iterator<Item>{
    private Node current = firstItem;
    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Item next() {
        if(current == null){
            throw new NoSuchElementException();
        }else {
        Item item  = current.item;
        current = current.next;
        return item;}
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
    private class Node {
        Item item;
        Node next;
        Node previous;


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

    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException();
        else if (firstItem == null) {
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
    public void addLast(Item item){
        if(item == null)
            throw new NullPointerException();
        else if(lastItem == null){
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
    public Item removeFirst(){
        Item it;
        if(size()==0){
            throw new NoSuchElementException("deque is empty");
        }
        else{
            it = firstItem.item;
            firstItem = firstItem.next;
            N--;

        }return it;
    }
    public Item removeLast(){
        Item it;
        if(size()==0){
            throw new NoSuchElementException("deque is empty");
        }else{
            it = lastItem.item;
            lastItem = lastItem.previous;
            N--;

        }return it;
    }

    public static void main(String[] args) {

    }

}
