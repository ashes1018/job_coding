package com.leetcode;

public class search_in_rotated_array {
	
//	找出旋转有序数组中指定数的下标，数组数字无重复
	public int findIndex(int[]A ,int target, int n) {
		int left = 0;
		int right = n - 1;
		while(left <= right){
			int mid = (left + right)/2;
			if(A[mid] == target){
				return mid;
			}else if(A[mid] < A[right]){
				if(A[mid] < target && A[right] >= target){
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}else{
				if(A[mid] > target && A[left] <= target){
					right = mid - 1;
				}else{
					left = mid +1;
				}
			}		 
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {4,5,6,7,0,1,2};
		System.out.println(new search_in_rotated_array().findIndex(A, 1, 7));
	}
}
