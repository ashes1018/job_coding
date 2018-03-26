package com.leetcode;

public class jianzhi_duplicateNumInArray_33 {

	public int getDuplicateNumInArray(int []nums) {
		if(nums == null || nums.length <= 0 ){
			return -1;
		}
		int start = 1;
		int end = nums.length - 1;
		while (end >= start) {
			int middle = (end - start)/2 + 1;
			int count = countNum(nums, start, middle);
			if(end == start){
				if(count > 1){
					return start;
				}else {
					break;
				}
			}			
			if(count > middle - start + 1){
				end = middle;
			}else{
				start = middle + 1;
			}
		}
		 return -1;
	}
	
	public int countNum(int[] nums, int start, int end) {
		if(nums == null){
			return 0;
		}
		int count = 0;
		for (int i : nums) {
			if(i >= start && i <= end){
				count ++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		 int[] nums = {2,3,5,4,3,6,7};
		 System.out.println(new jianzhi_duplicateNumInArray_33().getDuplicateNumInArray(nums));
	}
}
