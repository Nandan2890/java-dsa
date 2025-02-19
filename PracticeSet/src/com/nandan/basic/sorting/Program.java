package com.nandan.basic.sorting;

import java.util.Arrays;

public class Program {
	public static void main(String[] args) {
		int[] arr = {13, 46, 24, 52, 20, 9};
		
		selectionSort(arr, arr.length);
		
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
	
}
