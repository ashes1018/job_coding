package com.leetcode;

import java.util.Random;

public class jianzhi_quickSort_10 {
	
	public int partition(int[]data, int start, int end) {
		
		int index = new Random().nextInt(end - start + 1)+start;
		
		swap(data[index], data[end]);
		
		int i = start - 1;
		
		for(index = start ; index < end; index ++){
			if(data[index] < data[end]){
				i += 1;
				swap(data[i], data[index]);
			}			
		}
		swap(data[i+1], data[end]);		
		return i + 1;
	}
	
	public void quickSort(int[] data , int start, int end) {
		if(start < end){
			int q = partition(data, start, end);
			quickSort(data, start, q - 1);
			quickSort(data, q+1, end);
		}
	}
	
	public void swap(int a, int b) {
		int temp = 0;
		temp = a;
		a = b;
		b = temp;
	}
	
	public static void main(String[] args) {
		 int[] data = {2,8,7,1,3,5,6,4};
		 new jianzhi_quickSort_10().quickSort(data, 0, data.length-1);
		 for (int i : data) {
			System.out.println(i);
		}
	}

}
