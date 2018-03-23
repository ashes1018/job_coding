package com.leetcode;

import java.util.Arrays;

public class maximum_product_subarray {
	
	
//	这道题是要求连续相乘的最大值。由于会出现负数，例如[-3,2，-2]，所以在使用动规的时候，需要记录每个位置出现的最大最小值。
    public int maxProduct(int[] nums) {
    	if(nums == null || nums.length == 0 ){
    		return 0;
    	}
    	int[] max_dp = new int[nums.length];
    	int[] min_dp = new int[nums.length];   	
    	max_dp[0] = min_dp[0] = nums[0];
    	int max = nums[0];
    	for (int i = 1; i < nums.length; i++) {
    		min_dp[i] = Math.min(Math.min(max_dp[i-1] * nums[i], min_dp[i-1] * nums[i]), nums[i]);
    		max_dp[i] = Math.max(Math.max(max_dp[i-1] * nums[i], min_dp[i-1] * nums[i]), nums[i]);
    		max = Math.max(max, max_dp[i]);
		}
    	return max;
	}
    
    
	public static void main(String[] args) {
		 int[] nums = {-2,4,-3};
		 System.out.println(new maximum_product_subarray().maxProduct(nums));

	}

}
