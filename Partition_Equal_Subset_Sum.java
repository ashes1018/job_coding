package com.leetcode;

import java.util.Arrays;

public class Partition_Equal_Subset_Sum {
	
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int target = sum/2;
		if(sum %2 == 1){
			return false;
		}
		boolean[] dp = new boolean[target+1];
		Arrays.fill(dp, false);
		dp[0] = true;
		for(int i = 0; i < nums.length; i++) {
			for(int j = target; j >= nums[i]; --j){
				dp[j] = dp[j] || dp[j-nums[i]]; 
			}
		}
		return dp[dp.length - 1];
    }
	
	public static void main(String[] args) {
		int[] nums = {3,3,3,4,5};
		System.out.println(new Partition_Equal_Subset_Sum().canPartition(nums));
	}
}
