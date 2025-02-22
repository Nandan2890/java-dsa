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
	
	
//	*******************************************************
	//find middle node of the linked list
	public Node findMiddleNode() {
//		if the length variable is given;
//		if(length == 0) {
//			return null;
//		}
//		Node temp = head;
//		int mid = length/2;
//		for(int i = 0; i < mid; i++) {
//			temp = temp.next;
//		}
//		
//		return temp;
		
//		if the length variable is not given
//		using floyd's tortoise and hare algorithm(The concept of fast and slow pointer)
		Node fastPtr = head;
		Node slowPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		return slowPtr;
	}
	
	public boolean hasLoop() {
		Node fastPtr = head;
		Node slowPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr) {
				return true;
			}
		}
		
		return false;
	}
	
	
//	find kth node from the end of the linked list 
	public Node findkthNode(int k) {
		Node main_ptr = head;
        Node ref_ptr = head;
        
        int count=0;
        if(head != null){
            while(count < k){
                
                if(ref_ptr == null){
                    return null;
                }
                
                ref_ptr = ref_ptr.next;
                count++;
            }
            
            if(ref_ptr == null){
                if(head != null){
                    return head;
                }
            }
            else{
                while(ref_ptr != null){
                    main_ptr = main_ptr.next;
                    ref_ptr = ref_ptr.next;
                }
                return main_ptr;
            }
        }
        
        return null;
	}
	
	
	public void partitionList(int x) {
		if(head == null) {
			return;
		}
		
		Node dummy1 = new Node(0);
		Node dummy2 = new Node(0);
		Node prev1 = dummy1;
		Node prev2 = dummy2;
		
		
		Node current = head;
		
		while(current != null) {
			if(current.value < x) {
				prev1.next = current;
				prev1 = current;
			}else {
				prev2.next = current;
				prev2 = current;
			}
			
			current = current.next;
		}
		
		prev2.next = null;
		head = dummy1.next;
		prev1.next = dummy2.next;
		
	}
	
}
