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
		Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
//	printList: print all the nodes of the linkedList
	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
//	method to add element at the end of the list
	public void append(int value) {
		Node newNode = new Node(value);
		
		if(length==0) {
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
		
		length++;
	}
	
//	method to remove last item of the list
	public Node removeLast() {
		if(length == 0) return null;
		
		Node temp = head;
		Node pre = head;
		while(temp.next != null) {
			pre = temp;
			temp = temp.next;
		}
		
		tail = pre;
		tail.next = null;
		length--;
		if(length==0) {
			head = null;
			tail = null;
		}
		
		return temp;
	}
	
	
//	method to get head
	public void getHead() {
		System.out.println("Head: " + head.value);
	}
	
//	method to get tail
	public void getTail() {
		System.out.println("Tail: " + tail.value);
	}
	
//	method to get length of the list
	public void getLength() {
		System.out.println("Length: " + length);
	}
}
