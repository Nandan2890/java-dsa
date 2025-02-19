package com.nandan.basic.linkedlist;

public class LinkedList {
	private Node head;
	private Node tail;
	private int length;
	
	//constructor of LinkedList 
	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}
	
	class Node{
		int value;
		Node node;
		
		public Node(int value) {
			this.value = value;
		}
	}
}
