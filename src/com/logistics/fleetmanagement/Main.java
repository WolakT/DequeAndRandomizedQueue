package com.logistics.fleetmanagement;

public class Main {

    public static void main(String[] args) {
	Deque deque = new Deque();
        deque.addFirst("ala");
        deque.addLast("ma");
        deque.addLast("kota");
        System.out.println(deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        //System.out.println(deque.removeFirst());
    }
}
