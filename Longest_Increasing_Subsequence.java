package com.leetcode;

public class Longest_Increasing_Subsequence {
	
//	ʹ�ö�̬�滮�ķ�����dp[i]��ʾ��iλ��Ϊֹ������������Ƕ��١�
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i] > nums[j]){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
				max = Math.max(max, dp[i]);
			}		
		}
		return max;
	}
	public static void main(String[] args) {
		 int[] nums = {1,3,5,4,6,9,8};
		 System.out.println(new Longest_Increasing_Subsequence().lengthOfLIS(nums));
	}
}
