package com.nandan.basic.linkedlist;

public class Main {
	public static void main(String[] args) {
		LinkedList myLinkedList = new LinkedList(1);
		
		myLinkedList.append(2);
		myLinkedList.append(3);
		myLinkedList.append(1);
		myLinkedList.append(4);
		myLinkedList.append(2);
		myLinkedList.append(5);
		
//		Node node = myLinkedList.removeLast();
//		System.out.println(node.value);
//		
//		System.out.println(myLinkedList.removeLast());
		
//		myLinkedList.getHead();
//		myLinkedList.getTail();
//		myLinkedList.getLength();
		
		myLinkedList.printList();
		System.out.println("********************************");
//		System.out.println(myLinkedList.findMiddleNode().value);
//		System.out.println(myLinkedList.hasLoop());
//		System.out.println(myLinkedList.findkthNode(2).value);
//		myLinkedList.partitionList(8);
		myLinkedList.removeDuplicates2();
		myLinkedList.printList();
		
	}
}
