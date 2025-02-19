package com.nandan.basic.sorting;

import java.util.Arrays;

public class Program {
	public static void main(String[] args) {
		int[] arr = {13, 46, 24, 52, 20, 9};
//		int[] arr = {1,2,3,4,5};
		
//		selectionSort(arr, arr.length);
		bubbleSort(arr, arr.length);
//		insertionSort(arr, arr.length);
		
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void selectionSort(int[] arr, int n) {
		for(int i = 0; i < n-1; i++) {
			int mini = i;
			for(int j=i+1; j < n; j++) {
				if(arr[j] < arr[mini]) {
					mini = j;
				}
			}
			
			swap(arr, i, mini);
		}
	}
	
	public static void swap(int[] arr, int i, int mini) {
		int temp = arr[mini];
		arr[mini] = arr[i];
		arr[i] = temp;
	}
	
	public static void bubbleSort(int[] arr, int n) {
		boolean isChanged = false;    //it is used to check the array is already sorted or not for sorting optimization
//		for(int i = 0; i < n-1; i++) {
//			for(int j = 0; j < n-i-1; j++) {
//				if(arr[j] > arr[j+1]) {
//					swap(arr, j, j+1);
//				}
//			}
//		}
		
//		method 2 start from last index
		for(int i=n-1; i > 0; i--) {
			for(int j=0; j<=i-1; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					isChanged = true;
				}
//				System.out.println("run inner loop");
			}
//			System.out.println("Run outer loop");
			if(!isChanged) {
				break;
			}
		}
	}
	
	
	public static void insertionSort(int[] arr, int n) {
		for(int i = 1; i < n; i++) {
			int j = i;
			while(j > 0 && arr[j-1] > arr[j]) {
				swap(arr, j-1, j);
				j--;
			}
		}
	}
	
}
