package com.leetcode;

public class Subarray_Sum_Equals_K {
	
//	
	public int subarraySum(int[] nums, int k) {
//		sum[i]用于记录到i位置为止的累积和。
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		int count = 0;
//		获取到每个位置为止的累积和
		for(int i = 1 ; i <= nums.length ; i++){
			sum[i] = sum[i-1] + nums[i-1];
		}
//		重新遍历一次。
		for(int start = 0; start < nums.length ; start ++){
			for (int end = start+1; end <= nums.length; end++) {
				if(sum[end] - sum[start] == k){
					count ++;
				}
			}
		}
		return count;
	}
	
//	在第一次遍历的时候就进行对应计算，看是否等于k。
	public int subarraySum_2(int[] nums, int k) {
		
		int count = 0;
		for(int i = 0; i < nums.length; i++){
			int sum = 0;
			for(int j = i ; j < nums.length; j++ ){
				sum += nums[j];
				if(sum == k){
					count += 1;
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {1,2,2,2,2,1,1,1,2};
		System.out.println(new Subarray_Sum_Equals_K().subarraySum(nums, 2));
		System.out.println(new Subarray_Sum_Equals_K().subarraySum_2(nums, 2));
	}

}
