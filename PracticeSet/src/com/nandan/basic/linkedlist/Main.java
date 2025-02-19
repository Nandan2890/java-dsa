package com.nandan.basic.linkedlist;

import com.nandan.basic.linkedlist.LinkedList.Node;

public class Main {
	public static void main(String[] args) {
		LinkedList myLinkedList = new LinkedList(1);
		
		myLinkedList.append(2);
		myLinkedList.append(3);
		myLinkedList.append(4);
		myLinkedList.append(5);
		
		Node node = myLinkedList.removeLast();
		System.out.println(node.value);
		
		myLinkedList.getHead();
		myLinkedList.getTail();
		myLinkedList.getLength();
		
		myLinkedList.printList();
	}
}
