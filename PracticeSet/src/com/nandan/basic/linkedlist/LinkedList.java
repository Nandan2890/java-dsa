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
	
//	removeFirst() method to remove the first item from the linkedList
	public Node removeFirst() {
		if(length==0) {
			return null;
		}
		Node temp = head;
		head = head.next;
		temp.next = null;
		length--;
		
		if(length == 0) {
			tail=null;
		}
		
		return temp;
	}
	
//	prepend()method to add item at the first of the linkedList
	public void prepend(int value) {
		Node newNode = new Node(value);
		if(length==0) {
			head = newNode;
			tail = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
		
		length++;
	}
	
//	get(index) get the item from the specific index in the linkedList
	public Node get(int index) {
		if(index < 0 || index >= length) return null;
		
		Node temp = head;
		
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		
		return temp;
	}
	
//	set(index, value) change the value at the specific index
	public boolean set(int index, int value) {
		Node temp = get(index);
		if(temp != null) {
			temp.value = value;
			return true;
		}
		
		return false;
	}
	
//	//insert(int index, int value) insert the item at the specific index and push other item next and length will increase
    public boolean insert(int index, int value){
        if(index < 0 || index > length) return false;

        if(index==0){
            prepend(value);
            return true;
        }

        if(index==length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index-1);

        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }
    
    public Node remove(int index){
        if(index < 0 || index >= length){
            return null;
        }
        if(index == 0){
            return removeFirst();
        }
        if(index==length-1){
            return removeLast();
        }

        Node prev = get(index-1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }
    
 // public void reverse() is a method to reverse the linkedlist
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;
        for(int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
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
