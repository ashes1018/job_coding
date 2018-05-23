package com.leetcode;

public class jianzhi_11_minNumberInRotateArray {
	
	public int min(int[] nums) {
		int index1 = 0 ;
		int index2 = nums.length - 1;
		int indexMid = index1;
		int res = 0;
		
		while (nums[index2] <= nums[index1]) {
			if(index2 - index1 == 1){
				indexMid = index2;
				break;				
			}
			indexMid = (index1 + index2) /2;
			if(nums[index1] == nums[index2] && nums[index1] == nums[indexMid]){
				return findMin(nums);
			}
			if(nums[indexMid] >= nums[index1]){
				index1 = indexMid;
			}
			if(nums[indexMid] <= nums[index2]){
				index2 = indexMid;
			}						
		}
		return nums[indexMid];
	}
	
	public int findMin(int[] nums) {
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			min = Math.min(nums[i], min);
		}
		return min;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,4,5,0,2};
		int[] nums2 = {1,1,1,0,1};
		System.out.println(new jianzhi_11_minNumberInRotateArray().min(nums));
		System.out.println(new jianzhi_11_minNumberInRotateArray().min(nums2));
	}

}

