package com.leetcode;

public class MergeSort {
	
	public void mergeSort(int[] arr,int[] temp) {
		if(arr == null || arr.length <2)
			return;
		
		Msort(arr, 0, arr.length-1,temp);
	}
	
	public void Msort(int[]arr, int low, int high,int[] temp) {		
		if(low < high){
			int mid = (low + high) /2;
			Msort(arr, low, mid,temp);
			Msort(arr, mid+1, high,temp);
			mergeTwoList(arr, low, mid, high,temp);			
		}				
	}
	
	public void mergeTwoList(int[]arr, int left,int mid,int right,int[]C) {					
		int i =left;
		int j = mid+1;
		int k = 0;
		while(i <= mid && j <= right){
			if(arr[i] <= arr[j]){
				C[k++] = arr[i++]; 
			}else {
				C[k++] = arr[j++];
			}
		}
		while(i <= mid ){
			C[k++] = arr[i++];
		}
		while(j <=right ){
			C[k++] = arr[j++];
		}
		k = 0;
		while (left <= right) {
			arr[left++] = C[k++];
		}		
	}
	
	public static void main(String[] args) {
		int[] A  = {4,2,5,1,6,8};
		int [] temp = new int[A.length];
		new MergeSort().mergeSort(A,temp);
		for (int i : A) {
			System.out.println(i);
		}
	}
}
